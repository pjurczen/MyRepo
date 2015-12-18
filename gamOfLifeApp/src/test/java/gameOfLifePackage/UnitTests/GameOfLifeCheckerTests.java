package gameOfLifePackage.UnitTests;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import gameOfLifePackage.Cell;
import gameOfLifePackage.GameOfLife;

@RunWith(Parameterized.class)
public class GameOfLifeCheckerTests {
	private int expectedResult;
	private List<Cell> cells;
	private GameOfLifeChecker gameOfLifeChecker;
	private GameOfLife game;
	private long playedRounds;
	private long boundaries;
	
	@Before
	public void setUp() {
		game = new GameOfLife(boundaries);
		gameOfLifeChecker = new GameOfLifeChecker();
	}
	
	public GameOfLifeCheckerTests(List<Cell> cells, long boundaries, int expectedResult, long playedRounds, String testName) {
	      this.cells = cells;
	      this.expectedResult = expectedResult;
	      this.playedRounds = playedRounds;
	      this.boundaries = boundaries;
	}
	
	@Parameterized.Parameters(name = "{4}")
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] {
			{ Arrays.asList(new Cell(2, 2), new Cell(2, 3), new Cell(3, 2), new Cell(3, 3)), 10, 4, 1, "Test1"},
			{ Arrays.asList(new Cell(1, 2), new Cell(0, 3), new Cell(0, 5), new Cell(1, 3)), 10, 6, 1, "Test2"},
			{ Arrays.asList(new Cell(0, 2), new Cell(0, 3), new Cell(0, 7), new Cell(1, 3)), 10, 4, 1, "Test3"},
			{ Arrays.asList(new Cell(0, 2), new Cell(0, 3), new Cell(0, 7), new Cell(1, 3), new Cell(1, 2), new Cell(1, 5)), 10, 6, 1, "Test4"},
			
			{ Arrays.asList(new Cell(10, 10), new Cell(11, 10), new Cell(10, 11), new Cell(10, 12), new Cell(9, 11)), 2000, 6, 1, "F-pentomino after 1 round"},
			{ Arrays.asList(new Cell(10, 10), new Cell(11, 10), new Cell(10, 11), new Cell(10, 12), new Cell(9, 11)), 2000, 7, 2, "F-pentomino after 2 rounds"},
			{ Arrays.asList(new Cell(10, 10), new Cell(11, 10), new Cell(10, 11), new Cell(10, 12), new Cell(9, 11)), 2000, 9, 3, "F-pentomino after 3 rounds"},
			{ Arrays.asList(new Cell(10, 10), new Cell(11, 10), new Cell(10, 11), new Cell(10, 12), new Cell(9, 11)), 2000, 8, 4, "F-pentomino after 4 rounds"},
			{ Arrays.asList(new Cell(10, 10), new Cell(11, 10), new Cell(10, 11), new Cell(10, 12), new Cell(9, 11)), 2000, 9, 5, "F-pentomino after 5 rounds"},
			{ Arrays.asList(new Cell(1000, 1000), new Cell(1001, 1000), new Cell(1000, 1001), new Cell(1000, 1002), new Cell(999, 1001)), 2000, 116, 1103, "F-pentomino after 1103 rounds"},
			
			{ Arrays.asList(new Cell(100002, 100001), new Cell(100001, 100002), new Cell(100003, 100002), new Cell(100002, 100003),
					new Cell(100009, 100011), new Cell(100009, 100012), new Cell(100009, 100013),
					new Cell(100005, 100015), new Cell(100006, 100015), new Cell(100007, 100015),
					new Cell(100007, 100012), new Cell(100007, 100013), new Cell(100006, 100013)
					), 200000, 559, 500, "Lidka after 500 rounds"},
		});
	}
	
	@Test
	public void testGameOfLifeChecker() {
		assertEquals(expectedResult, gameOfLifeChecker.nextState(cells, game, playedRounds));
	}
}
