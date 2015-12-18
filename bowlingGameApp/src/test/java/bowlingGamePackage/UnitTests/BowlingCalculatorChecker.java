package bowlingGamePackage.UnitTests;

import java.util.List;

import bowlingGamePackage.BowlingCalculator;

public class BowlingCalculatorChecker {

	public int getScore(List<Integer> rolls, BowlingCalculator calculator) {
		rolls.forEach(x -> calculator.roll(x));
		return calculator.getScore();
	}
}
