import javafx.scene.control.Button;
public class Tiles extends Button {
	private int row, column, number;
	private static int rowBlank;
	private static int columnBlank;
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
		} else { // when the tile number is 0
			setEmptyTile();
		}
	}
	
	public boolean isMoveable(Tiles[][] puzzle, int row, int column) {
		// if the tile has a neighbor whose number == 0, then moveable otherwise not
		if (row == 1) {
			
		}
		if (puzzle[row+1][column].getNumber() == 0 ||
			puzzle[row-1][column].getNumber() == 0 ||
			puzzle[row][column-1].getNumber() == 0 ||
			puzzle[row][column+1].getNumber() == 0) {
			return true;
		} else {
			return false;
		}
	}
	public void setEmptyTile() {
		this.setNumber(0);
		this.setStyle ("-fx-base: # f4f162");
		setRowBlank(this.row);
		setColumnBlank(this.column);
	}
	
	public void updateTile(int num) {
		this.setNumber(num);
		this.setText(String.valueOf(this.number));
		String color = "-fx-background-color:lightyellow;";
//		if (num == 0) {
//			color = "-fx-base: # f4f162";
//			this.setText(String.valueOf(this.number));
//		}
		this.setStyle(color);
	}
	
	public void updateValidTileStates() {
		
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public int getRowBlank() {
		return rowBlank;
	}
	public int getColumnBlank() {
		return columnBlank;
	}
	public int getNumber() {
		return number;
	}
	public void setRowBlank(int rowBlank) {
		Tiles.rowBlank = rowBlank;
	}
	public void setColumnBlank(int columnBlank) {
		Tiles.columnBlank = columnBlank;
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
