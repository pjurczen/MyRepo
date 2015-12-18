package bowlingGamePackage.UnitTests;

import java.util.List;

import bowlingGamePackage.BowlingCalculator;

public class BowlingFramesChecker {

	public int getFrame(List<Integer> rolls, BowlingCalculator calculator) {
		rolls.forEach(x -> calculator.roll(x));
		return calculator.getFrameNumber();
	}

}
