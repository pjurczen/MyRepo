package gameOfLifePackage;

public class DeadCell extends Cell{

	public DeadCell(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String toString() {
		return "DeadCell " + getX() + ", " + getY();
	}
}
