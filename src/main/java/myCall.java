import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class myCall implements Callable <ArrayList<Node>> {

	
	JavaFXTemplate test;
	String heuristic;
	
	int[] convert1;

	A_IDS_A_15solver ids;
	
	
	
	//constructor
	myCall(int[][] puzzle, int algoNum) {
		 
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
		 if (algoNum == 1) {
			 heuristic = "heuristicOne";
		 } else {
			 heuristic = "heuristicTwo";
		 }
	}
	
	
	@Override
	public ArrayList<Node> call() throws Exception {
		
	
		
		ids = new A_IDS_A_15solver();
		
		System.out.println("testing");
		System.out.println(Arrays.toString(convert1));
	
		
		Node startState = new Node(convert1);		//node contains the start state of puzzle
		startState.setDepth(0);

		
		ArrayList<Node> solutionPath = ids.A_Star(startState, heuristic);	
		//ids.printSolution(solutionPath);
		
		System.out.println("Check this shit out: " + Arrays.toString(solutionPath.get(1).getKey()));
		
		
	

		return solutionPath;
		
		
	}

}
