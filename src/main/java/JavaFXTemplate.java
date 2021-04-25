import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	String puzzle1 = "2 6 10 3 1 4 7 11 8 5 9 15 12 13 14 0";
	Tiles[][] puzzle = new Tiles[4][4];
	
	EventHandler<ActionEvent> checkPosition; // to know the which tile was clicked
	
	PauseTransition pause = new PauseTransition(Duration.seconds(4)); // later on for when AI solves, but we need pauses in between
	
	BorderPane puzzlePane; // main scene for our puzzle
	GridPane gridpane; // this should be where the tiles go
	MenuBar menuBar;
	Menu menuGamePlay, menuOptions, howTo;
	MenuItem exit, newPuzzle, solve1, solve2, showSolution, instr;
	Button enter;
	Label howToPlay, moveString, moveNumber;
	int numberOfMoves = 0;
	int moveDirection = 0;
	TextField userInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Project 4");
		exit = new MenuItem("Exit");
		newPuzzle = new MenuItem("New Puzzle");
		solve1 = new MenuItem("Solve 1");
		solve2 = new MenuItem("Solve 2");
		showSolution = new MenuItem("Show Solution");
		instr = new MenuItem("How To Play");
		checkPosition = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				Tiles tile = (Tiles)event.getSource();
				int row = tile.getRow();
				int column = tile.getColumn();
				int num = tile.getNumber();
				
				
				//check if the blank tile is one of the neighbors
				int rowBlank = tile.getRowBlank();
				int columnBlank = tile.getColumnBlank();
				System.out.println("Blank tile at (" + rowBlank + ", " + columnBlank + ")");
				System.out.println("Selected tile at (" + row + ", " + column + ")");
				if (row == rowBlank ) { // means the clicked tile and blank tile are in the same row\
					System.out.println("Same row");
					if (column > columnBlank && (column+1 == columnBlank || column-1 == columnBlank)) {
						moveDirection = -1; // move selected row down
					} else if (column < columnBlank && (column+1 == columnBlank || column-1 == columnBlank)) {
						moveDirection = 1; // move selected row up
					} else {
						moveDirection = 0;
					}
					System.out.println("Moving: " + moveDirection);
				} else if (column == columnBlank) {
					System.out.println("Same column");
					if (row > rowBlank && (row+1 == rowBlank || row-1 == rowBlank)) {
						moveDirection = -1; // move selected row down
					} else if (row < rowBlank && (row+1 == rowBlank || row-1 == rowBlank)) {
						moveDirection = 1; // move selected row up
					} else {
						moveDirection = 0;
					}
					System.out.println("Moving: " + moveDirection);
				} else {
					moveDirection = 0;
				}
				
				
				if (moveDirection != 0 ) {
					numberOfMoves++;
					moveNumber.setText(String.valueOf(numberOfMoves));
					if (moveDirection == 1) {
						puzzle[row][column].setEmptyTile(); // set's to empty
						puzzle[row][column].setText("");
						puzzle[rowBlank][columnBlank].updateTile(num);
					} else if (moveDirection == -1) { // -1 move direction
						puzzle[row][column].setEmptyTile(); // set's to empty
						puzzle[row][column].setText("");
						puzzle[rowBlank][columnBlank].updateTile(num); // change the empty to selected one
					}
				}
				
			}

		};
		
		// first we should intialized our puzzle to one of the 10 that we need
		
		
		// then we should set it up so we can display our puzzle to the JavaFx
		
		
		// Just like how we did in connect four we need to check if a move is valid, but this time
		// we need to check if the tile(Button) that was clicked has a neighbor which value is 0 (blank tile)
		// if so, we swap the place of that clicked tile with the blank tile
		
		
		

		
		
		
		
		
				
		Scene scene = mainPuzzleScene();
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Thread t = new Thread(()-> {A_IDS_A_15solver ids = new A_IDS_A_15solver();});
		t.start();

	}
	// we need to have either another function to intialize the values in the buttons or do with a parameter on newPuzzle()
	void newPuzzle(GridPane gridPane) {
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Tiles t = new Tiles(i,j, counter); // zero should be the number of that puzzle tile
				t.setMinSize(100, 100);
				t.setOnAction(checkPosition);
				puzzle[i][j] = t;
				gridPane.add(puzzle[i][j], j, i);
				counter++;
			}
		}
		
	}
	
	public void setMenuOptions () {
		menuGamePlay = new Menu( "Game Play");
		menuOptions = new Menu ("Options");
		howTo = new Menu ("Instructions");
		menuOptions.getItems().addAll(newPuzzle, exit);
		menuGamePlay.getItems().addAll(solve1, solve2, showSolution);
		howTo.getItems().addAll(instr);
		menuBar.getMenus().addAll(menuGamePlay, menuOptions, howTo);
		
	}
	
	public Scene mainPuzzleScene() {
		menuBar = new MenuBar();
		setMenuOptions();
		gridpane = new GridPane();
		newPuzzle(gridpane);
		gridpane.setHgap(2);
		gridpane.setVgap(2);
		puzzlePane = new BorderPane();
		puzzlePane.setTop(menuBar);
		
		howToPlay = new Label("");
		howToPlay.setFont(new Font("Arial",18));
		
		moveString = new Label();
		moveString.setFont(new Font("Arial",18));
		moveString.setText("Move #: ");
		moveNumber = new Label();
		moveNumber.setFont(new Font("Arial",18));
		moveNumber.setText(String.valueOf(numberOfMoves));
		
		
		gridpane.setAlignment(Pos.CENTER);
		HBox hB = new HBox(moveString, moveNumber);
		hB.setAlignment(Pos.CENTER);
		
		VBox vB = new VBox(hB, gridpane);
		
		vB.setAlignment(Pos.CENTER);
		
		puzzlePane.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		
		puzzlePane.setCenter(vB);
		
		return new Scene(puzzlePane, 800, 800);
	}

}
