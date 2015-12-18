package pokerSetsComparerPackage.UnitTests;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class WinnerCheckerTest {
	private int expectedResult;
	private int inputNumber;
	private WinnerChecker winnerChecker;

	@Before
	public void setUp() {
		winnerChecker = new WinnerChecker();
	}

	public WinnerCheckerTest(Integer inputNumber, int expectedResult) {
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] {
			{ 0, -1 },
			{ 1, 1 },
			{ 2, 1 },
			{ 3, -1 },
			{ 4, -1 },
		});
	}

	@Test
	public void testWinnerChecker() {
		assertEquals(expectedResult, winnerChecker.getWinner(inputNumber));
	}
}

