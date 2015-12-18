package bowlingGamePackage.UnitTests;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import bowlingGamePackage.BowlingCalculator;

@RunWith(Parameterized.class)
public class BowlingCalculatorCheckerTest {

	private BowlingCalculator calculator;
	private BowlingCalculatorChecker bowlingCalculatorChecker;
	private int expectedResult;
	private List<Integer> rolls;

	@Before
	public void setUp() {
		bowlingCalculatorChecker = new BowlingCalculatorChecker();
		calculator = new BowlingCalculator();
	}

	public BowlingCalculatorCheckerTest(List<Integer> rolls, int expectedResult) {
		this.expectedResult = expectedResult;
		this.rolls = rolls;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { { Arrays.asList(), 0 }, { Arrays.asList(10), 10 },
				{ Arrays.asList(1, 2), 3 }, { Arrays.asList(10, 1, 1), 14 }, { Arrays.asList(10, 10, 10), 60 },
				{ Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 10), 170 },
				{ Arrays.asList(10, 9, 1, 1), 32 },
				{ Arrays.asList(10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10), 187 },
				{ Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10), 300 },
				{ Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10), 300 }, });
	}

	@Test
	public void testGameOfLifeChecker() {
		assertEquals(expectedResult, bowlingCalculatorChecker.getScore(rolls, calculator));
	}
}
