import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class myCall implements Callable<Integer> {

	JavaFXTemplate test;
	int[] convert1;
	A_IDS_A_15solver ids;
	
	
	//constructor
	myCall(int[][] puzzle) {
		 
	// convert 2d to 1d array to throw in algo
    ArrayList<Integer> list = new ArrayList<Integer>();
	for (int i = 0; i < puzzle.length; i++) {
		for (int j = 0; j < puzzle[i].length; j++) { 
		      list.add(puzzle[i][j]); 
		 }
    }
		    
		 convert1 = new int[list.size()];
		 System.out.println(list.size());
		 
		 for (int i = 0; i < convert1.length; i++) {
		        convert1[i] = list.get(i);
		 }
	}
	
	
	@Override
	public Integer call() throws Exception {
		System.out.println("testing");
		System.out.println(Arrays.toString(convert1));
	
		
		Node startState = new Node(convert1); //node contains the start state of puzzle
		startState.setDepth(0);
		
		
		ids.A_Star(startState, "heuristicOne");	
		// just returning integer for testing
		return 2;
		

	}
}
