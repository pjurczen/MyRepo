package gameOfLifePackage.UnitTests;

import java.util.*;

import gameOfLifePackage.Cell;
import gameOfLifePackage.GameOfLife;

public class GameOfLifeChecker {
	public int nextState(List<Cell> cells, GameOfLife game, long playedRounds) {
		cells.forEach(x -> game.addCell(x.getX(), x.getY()));
		for(int i = 0; i < playedRounds; i++){
			game.nextState();
		}
		return game.getCellsCount();
	}

}
