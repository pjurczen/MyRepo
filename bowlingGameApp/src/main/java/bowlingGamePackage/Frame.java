package bowlingGamePackage;

public class Frame {
	private static final int MAX_ROLLS_INCL_FINAL_FRAME = 3;
	private static final int SPARE_BONUS = 1;
	private static final int STRIKE_BONUS = 2;
	private int score;
	private int currentFrame = 1;
	private int rollsInFrame;
	private int bonusLefts;
	private boolean strikeBonus;
	private boolean spareBonus;

	public Frame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public void increaseScore(int pins) {
		if (rollsInFrame <= MAX_ROLLS_INCL_FINAL_FRAME) {
			score += pins;
		}
	}

	public int getScore() {
		return score;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void increaseRollsInFrame() {
		rollsInFrame++;
	}

	public int getRollsInFrame() {
		return rollsInFrame;
	}

	public int getBonusLefts() {
		return bonusLefts;
	}

	public void decreaseBonusLefts() {
		bonusLefts--;
	}

	public void setStrikeBonus() {
		bonusLefts = STRIKE_BONUS;
		strikeBonus = true;
	}

	public void setSpareBonus() {
		bonusLefts = SPARE_BONUS;
		spareBonus = true;
	}

	public void cancelStrikeBonus() {
		strikeBonus = false;
	}

	public void cancelSpareBonus() {
		spareBonus = false;
	}

	public boolean isStrikeBonus() {
		return strikeBonus;
	}

	public boolean isSpareBonus() {
		return spareBonus;
	}
}
