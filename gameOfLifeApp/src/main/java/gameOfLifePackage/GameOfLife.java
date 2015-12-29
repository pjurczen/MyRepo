package gameOfLifePackage;

import java.util.*;
import java.util.stream.Collectors;

public class GameOfLife {
	private List<Cell> cellsOnBoard;
	private List<Cell> cellsToKill;
	private List<Cell> cellsToGiveLife;
	private List<Cell> cellsDead;
	private long boardSize;
	
	public GameOfLife(long boardSize) {
		this.boardSize = boardSize;
		cellsOnBoard = new ArrayList<Cell>();
		cellsToKill = new ArrayList<Cell>();
		cellsToGiveLife = new ArrayList<Cell>();
		cellsDead = new ArrayList<Cell>();
	}
	
	public void addCell(int x, int y) {
		if(!cellsOnBoard.contains(new Cell(x,y)) && (x >= 0 && x < boardSize) && (y >= 0 && y < boardSize)) {
			cellsOnBoard.add(new Cell(x,y));
			cellsDead.remove(new DeadCell(x,y));
			addDeadCells(x, y);
		}
	}
	
	public void removeCell(int x, int y) {
		cellsOnBoard.remove(new Cell(x,y));
	}

	public int getCellsCount() {
		return cellsOnBoard.size();
	}
	
	public int getDeadCellsCount() {
		return cellsDead.size();
	}
	
	public void nextState() {
		countNeighbours(cellsOnBoard);
		countNeighbours(cellsDead);
		killCells();
		giveLifeToCells();
		eraseDeadCells();
	}

	private void eraseDeadCells() {
		countNeighbours(cellsDead);
		List<Cell> tmpDeadCells;
		tmpDeadCells = cellsDead.stream().filter(deadCell -> deadCell.getNeighboursCount() == 0).collect(Collectors.toList());
		tmpDeadCells.forEach(cellToErase -> cellsDead.remove(cellToErase));
	}

	private void giveLifeToCells() {
		cellsDead.stream().filter(deadCell -> deadCell.getNeighboursCount() == 3).forEach(deadCell -> cellsToGiveLife.add(new Cell(deadCell.getX(), deadCell.getY())));
		for (Cell cellToGiveLife : cellsToGiveLife) {
			cellsOnBoard.add(cellToGiveLife);
			cellsDead.remove(new DeadCell(cellToGiveLife.getX(), cellToGiveLife.getY()));
			addDeadCells(cellToGiveLife.getX(), cellToGiveLife.getY());
		}
		cellsToGiveLife.clear();
	}

	private void killCells() {
		cellsOnBoard.stream().filter(cell -> cell.getNeighboursCount() < 2 || cell.getNeighboursCount() > 3).forEach(cell -> cellsToKill.add(cell));
		for (Cell cellToKill : cellsToKill) {
			cellsDead.add(new DeadCell(cellToKill.getX(), cellToKill.getY()));
			cellsOnBoard.remove(cellToKill);
		}
		cellsToKill.clear();
	}
	
	private void addDeadCells(int x, int y) {
		for(int i = x - 1; i <= x + 1; i++) {
			for(int j = y - 1; j <= y + 1; j++) {
				if((i >= 0 && i < boardSize) && (j >= 0 && j < boardSize) && !cellsDead.contains(new DeadCell(i,j)) && !cellsOnBoard.contains(new Cell(i,j))) {
					cellsDead.add(new DeadCell(i, j));
				}
			}
		}
		cellsDead.remove(new DeadCell(x, y));
	}
	
	public void countNeighbours(Collection<Cell> cellsToCount) {
		for (Cell cell : cellsToCount) {
			cell.resetNeighboursCount();
			for(int i = cell.getX() - 1; i <= cell.getX() + 1; i++) {
				for(int j = cell.getY() - 1; j <= cell.getY() + 1; j++) {
					if(cellsOnBoard.contains(new Cell(i, j)) && !cell.equals(new Cell(i, j))) {
						cell.increaseNeighboursCount();
					}
				}
			}
		}
	}
}
