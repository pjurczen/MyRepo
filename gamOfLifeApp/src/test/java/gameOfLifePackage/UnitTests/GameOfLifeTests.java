package gameOfLifePackage.UnitTests;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gameOfLifePackage.Cell;
import gameOfLifePackage.GameOfLife;

public class GameOfLifeTests {
	private GameOfLife game;
	private Random random;
	
	@Before
	public void setUp() {
		game = new GameOfLife(5);
		random = new Random();
	}

	@Test
	public void shouldCellsBeEqualWhenHaveTheSameCoordinates() {
		//given
		Cell c1 = new Cell(1, 2);
		Cell c2 = new Cell(1, 2);
		//when
		
		//then
		Assert.assertEquals(c1, c2);
	}

	@Test
	public void shouldCellsBeNotEqualWhenHaveDifferentCoordinates() {
		//given
		Cell c1 = new Cell(1, 2);
		Cell c2 = new Cell(1, 3);
		//when
		
		//then
		Assert.assertNotSame(c1, c2);
	}
	
	@Test
	public void shouldCellExistsWhenAdded() {
		//given
		game.addCell(0,0);
		//when
		int cellsCount = game.getCellsCount();
		//then
		Assert.assertEquals(1, cellsCount);
	}
	
	@Test
	public void shouldCellExistsWhenAddedAndRemoved() {
		//given
		game.addCell(0,0);
		game.removeCell(0, 0);
		//when
		int cellsCount = game.getCellsCount();
		//then
		Assert.assertEquals(0, cellsCount);
	}
	
	@Test
	public void shouldCellExistOnceWhenSameAddedTwice() {
		//given
		game.addCell(0,0);
		game.addCell(0,0);
		//when
		int cellsCount = game.getCellsCount();
		//then
		Assert.assertEquals(1, cellsCount);
	}
	
	@Test
	public void shouldCellDieWhenAlone() {
		//given
		game.addCell(1, 1);
		game.nextState();
		//when
		int cellsCount = game.getCellsCount();
		//then
		Assert.assertEquals(0, cellsCount);
	}
		
	@Test
	public void shouldDeadCelllRiseAliveWhenHasThreeNeighbours() {
		//given
		game.addCell(2, 2);
		game.addCell(3, 2);
		game.addCell(2, 3);
		game.addCell(3, 3);
		game.nextState();
		//when
		int cellsCount = game.getCellsCount();
		//then
		Assert.assertEquals(4, cellsCount);
	}
	
	@Test
	public void shouldCellNotExistWhenOutOfBoard() {
		//given
		game.addCell(-1, 2);
		//when
		int cellsCount = game.getCellsCount();
		//then
		Assert.assertEquals(0, cellsCount);
	}
	
	@Test
	public void testTheGame() {
		//given
		for (int i = 0; i < 6; i++) {
			game.addCell(random.nextInt(5), random.nextInt(5));
		}
		game.nextState();
		game.nextState();
		game.nextState();
		game.nextState();
		//when
		int cellsDead = game.getDeadCellsCount();
		//then
		Assert.assertTrue(cellsDead <= 25);
	}
}
