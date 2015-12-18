package bowlingGamePackage.UnitTests;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import bowlingGamePackage.BowlingCalculator;

@RunWith(Parameterized.class)
public class BowlingFramesCheckerTest {

	private BowlingCalculator calculator;
	private BowlingFramesChecker bowlingFramesChecker;
	private int expectedResult;
	private List<Integer> rolls;

	@Before
	public void setUp() {
		bowlingFramesChecker = new BowlingFramesChecker();
		calculator = new BowlingCalculator();
	}

	public BowlingFramesCheckerTest(List<Integer> rolls, int expectedResult) {
		this.expectedResult = expectedResult;
		this.rolls = rolls;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { { Arrays.asList(), 1 }, { Arrays.asList(1), 1 },
				{ Arrays.asList(1, 2), 2 }, { Arrays.asList(10), 2 }, { Arrays.asList(10, 1, 1), 3 },
				{ Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 10), 10 },
				{ Arrays.asList(10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10), 10 }, });
	}

	@Test
	public void testGameOfLifeChecker() {
		assertEquals(expectedResult, bowlingFramesChecker.getFrame(rolls, calculator));
	}
}
