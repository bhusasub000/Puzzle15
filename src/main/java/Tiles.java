import java.awt.Button;

public class Tiles extends Button {
	private int row, column, number;
	private boolean disabled;
	
	Tiles(int row, int column, int number) {
		this.row = row;
		this.column = column;
		this.disabled = true;
		this.number = number;
	}
	
	public boolean isMoveable(Tiles[][] puzzle, int row, int column) {
		// if the tile has a neighbor whose number == 0, then moveable otherwise not
		return false;
	}
	
	
	
}
