package bowlingGamePackage;

import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
	private static final int FINAL_FRAME = 10;
	private static final int MAX_ROLLS = 2;
	private static final int MAX_SCORE_IN_FRAME = 10;
	private List<Frame> frames;
	private Frame frame;
	private Frame previousFrame;
	private Frame twicePreviousFrame;
	private int currentFrame = 1;
	private int totalScore;

	public BowlingCalculator() {
		frames = new ArrayList<Frame>();
		frames.add(new Frame(currentFrame));
		frame = frames.get(currentFrame - 1);
	}

	public void roll(int pins) {
		frame = frames.get(currentFrame - 1);
		frame.increaseRollsInFrame();
		frame.increaseScore(pins);
		getPreviousFrames();
		grantStrikeBonus(pins);
		grantSpareBonus(pins);
		increaseFrame(pins);
	}

	private void getPreviousFrames() {
		if (currentFrame > 2) {
			twicePreviousFrame = frames.get(currentFrame - 3);
		}
		if (currentFrame > 1) {
			previousFrame = frames.get(currentFrame - 2);
		}
	}

	private void grantStrikeBonus(int pins) {
		if (frame.getScore() >= MAX_SCORE_IN_FRAME && frame.getRollsInFrame() == 1 && currentFrame < FINAL_FRAME) {
			frame.setStrikeBonus();
		}
		applyStrikeBonus(pins);
	}

	private void grantSpareBonus(int pins) {
		if (frame.getScore() == MAX_SCORE_IN_FRAME && frame.getRollsInFrame() == MAX_ROLLS
				&& currentFrame < FINAL_FRAME) {
			frame.setSpareBonus();
		}
		applySpareBonus(pins);
	}

	private void applySpareBonus(int pins) {
		if (currentFrame > 1 && previousFrame.isSpareBonus()) {
			previousFrame.increaseScore(pins);
			previousFrame.decreaseBonusLefts();
			previousFrame.cancelSpareBonus();
		}
	}

	private void applyStrikeBonus(int pins) {
		if (currentFrame > 1 && previousFrame.isStrikeBonus()) {
			previousFrame.increaseScore(pins);
			previousFrame.decreaseBonusLefts();
			if (previousFrame.getBonusLefts() == 0) {
				previousFrame.cancelStrikeBonus();
			}
		}
		if (currentFrame > 2 && twicePreviousFrame.isStrikeBonus()) {
			twicePreviousFrame.increaseScore(pins);
			twicePreviousFrame.decreaseBonusLefts();
			twicePreviousFrame.cancelStrikeBonus();
		}
	}

	public int getFrameNumber() {
		return currentFrame;
	}

	public int getScore() {
		totalScore = 0;
		frames.forEach(frame -> totalScore += frame.getScore());
		return totalScore;
	}

	private void increaseFrame(int pins) {
		if ((pins == MAX_SCORE_IN_FRAME || frame.getRollsInFrame() == MAX_ROLLS)
				&& frame.getCurrentFrame() < FINAL_FRAME) {
			currentFrame++;
			frames.add(new Frame(currentFrame));
		}
	}
}