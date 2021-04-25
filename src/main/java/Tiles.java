import javafx.scene.control.Button;
public class Tiles extends Button {
	private int row, column, number;
	private boolean disabled;
	
	Tiles(int row, int column, int number) {
		this.row = row;
		this.column = column;
		this.disabled = true;
		this.number = number;
		if (number != 0) {
			this.setText(String.valueOf(this.number));
			String color = "-fx-background-color:lightyellow;";
			this.setStyle(color);
		}
	}
	
	public boolean isMoveable(Tiles[][] puzzle, int row, int column) {
		// if the tile has a neighbor whose number == 0, then moveable otherwise not
		return false;
	}
	
	public void updateValidTileStates() {
		
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public int getNumber() {
		return number;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void changeDisable(boolean x) {
		this.disabled = x;
	}
	
}
