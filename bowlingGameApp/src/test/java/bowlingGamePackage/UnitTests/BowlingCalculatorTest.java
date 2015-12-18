package bowlingGamePackage.UnitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bowlingGamePackage.BowlingCalculator;

public class BowlingCalculatorTest {

	private BowlingCalculator calculator;

	@Before
	public void setUp() {
		calculator = new BowlingCalculator();
	}

	@Test
	public void shouldHandleNoRolls() {
		// given

		// when
		int frameNumber = calculator.getFrameNumber();
		// then
		Assert.assertEquals(1, frameNumber);
	}

	@Test
	public void shouldHandleOneRoll() {
		// given
		calculator.roll(1);
		// when
		int frameNumber = calculator.getFrameNumber();
		// then
		Assert.assertEquals(1, frameNumber);
	}

	@Test
	public void shouldHandleTwoRolls() {
		// given

		calculator.roll(1);
		calculator.roll(2);
		// when
		int frameNumber = calculator.getFrameNumber();
		// then
		Assert.assertEquals(2, frameNumber);
	}

	@Test
	public void shouldHandleStrike() {
		// given

		calculator.roll(10);
		// when
		int frameNumber = calculator.getFrameNumber();
		// then
		Assert.assertEquals(2, frameNumber);
	}

	@Test
	public void shouldHandleStrikeAndTwoRolls() {
		// given
		calculator.roll(10);
		calculator.roll(1);
		calculator.roll(1);
		// when
		int frameNumber = calculator.getFrameNumber();
		// then
		Assert.assertEquals(3, frameNumber);
	}

	@Test
	public void shouldHandle18_5and3Strikes() {
		// given
		for (int i = 0; i < 18; i++) {

			calculator.roll(5);
		}
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		// when
		int frameNumber = calculator.getFrameNumber();
		// then
		Assert.assertEquals(10, frameNumber);
	}

	@Test
	public void shouldGetProperScore() {
		// given

		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(0, score);
	}

	@Test
	public void shouldGetProperScoreWithRolls() {
		// given
		calculator.roll(10);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(10, score);
	}

	@Test
	public void shouldGetProperScoreWithTwoRolls() {
		// given
		calculator.roll(1);
		calculator.roll(2);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(3, score);
	}

	@Test
	public void shouldGetProperScoreWithStrikeAndTwoRolls() {
		// given
		calculator.roll(10);
		calculator.roll(1);
		calculator.roll(1);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(14, score);
	}

	@Test
	public void shouldGetProperScoreWithThreeStrikes() {
		// given
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(60, score);
	}

	@Test
	public void shouldGetProperScoreInLastFrame() {
		// given
		for (int i = 0; i < 18; i++) {

			calculator.roll(5);
		}
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(170, score);
	}

	@Test
	public void shouldGetProperScoreForStrikeAndSpareInARow() {
		// given
		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(1);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(32, score);
	}

	@Test
	public void shouldGetProperScoreForAll() {
		// given
		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(5);
		calculator.roll(5);
		calculator.roll(7);
		calculator.roll(2);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(0);
		calculator.roll(8);
		calculator.roll(2);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(10);
		// when
		int score = calculator.getScore();
		// then
		Assert.assertEquals(187, score);
	}
}
