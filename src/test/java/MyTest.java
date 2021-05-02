import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	A_IDS_A_15solver test = new A_IDS_A_15solver();
	myCall callA;

	@Test
	void testConversionSizeA() {
		
		
		int [][] puzzle1 = {{2, 6, 10, 3}, {1, 4, 7, 11}, {8, 5, 9, 15}, {12, 13, 14, 0}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 1);
		
		
		assertEquals(16, check.convert1.length, "Current Player value is wrong");
	}
	
	@Test
	void testConversionSizeB() {
		
		
		int [][] puzzle1 = {{14,12,1,3},{0,5,15,7},{13,8,11,4},{2,6,9,10}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 2);
		
		
		assertEquals(16, check.convert1.length, "Current Player value is wrong");
	}
	
	@Test
	void testConversionPrintA() {
		
		
		int [][] puzzle1 = {{3,6,15,9}, {4,11,14,5}, {2,10,1,7}, {12,0,8,13}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 2);
		int[] x = {3,6,15,9,4,11,14,5,2,10,1,7,12,0,8,13};
		
		assertEquals(Arrays.toString(x), Arrays.toString(check.convert1), "Current Player value is wrong");
	}

	@Test
	void testConversionPrintB() {
		
		
		int [][] puzzle1  = {{0,7,11,9}, {2,14,5,6}, {3,13,12,1}, {15,8,4,10}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 2);
		int[] x = {0,7,11,9,2,14,5,6,3,13,12,1,15,8,4,10};
		
		assertEquals(Arrays.toString(x), Arrays.toString(check.convert1), "Current Player value is wrong");
	}
	@Test
	void testCorrectHeuristicA() {
		
		
		int [][] puzzle1  = {{0,7,11,9}, {2,14,5,6}, {3,13,12,1}, {15,8,4,10}};
		// using heuristic 2
		myCall check = new myCall(puzzle1, 2);
		String x = check.heuristic;
		
		
		assertEquals("heuristicTwo",x, "Current Player value is wrong");
	}
	@Test
	void testCorrectHeuristicB() {
		
		
		int [][] puzzle1  = {{0,7,11,9}, {2,14,5,6}, {3,13,12,1}, {15,8,4,10}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 1);
		String x = check.heuristic;
		
		
		assertEquals("heuristicOne",x, "Current Player value is wrong");
	}
	
	@Test
	void testWinA() {
		
		// i know the size of the solution path here is 1 so we will test to make sure that the paths size are the same
		int [][] puzzle1 = {{1, 0, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 1);
		
		
		Node startState = new Node(check.convert1);		
		startState.setDepth(0);
		ArrayList<Node> solution = test.A_Star(startState, check.heuristic);
		// 2 because initial and goal state
		assertEquals(2, solution.size(), "Solution path is wrong");
	}
	
	@Test
	void testWinB() {
		
		// i know the size of the solution path here is 1 so we will test to make sure that the paths size are the same
		int [][] puzzle1 = {{0,1,2,3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 1);
		
		
		Node startState = new Node(check.convert1);		
		startState.setDepth(0);
		ArrayList<Node> solution = test.A_Star(startState, check.heuristic);
		
		assertEquals(1, solution.size(), "Solution path is wrong");
	}
	
	
	@Test
	void testWinC() {
		
		// i know the size of the solution path here is 1 so we will test to make sure that the paths size are the same
		int [][] puzzle1  = {{2, 6, 10, 3}, {1, 4, 7, 11}, {8, 5, 9, 15}, {12, 13, 14, 0}};
		// using heuristic 1
		myCall check = new myCall(puzzle1, 1);
		
		
		Node startState = new Node(check.convert1);		
		startState.setDepth(0);
		ArrayList<Node> solution = test.A_Star(startState, check.heuristic);
		
		assertEquals(39, solution.size(), "Solution path is wrong");
	}
	
	@Test
	void testWinD() {
		
		// i know the size of the solution path here is 1 so we will test to make sure that the paths size are the same
		int [][] puzzle1  = {{2, 6, 10, 3}, {1, 4, 7, 11}, {8, 5, 9, 15}, {12, 13, 14, 0}};
		// using heuristic 2
		myCall check = new myCall(puzzle1, 2);
		
		
		Node startState = new Node(check.convert1);		
		startState.setDepth(0);
		ArrayList<Node> solution = test.A_Star(startState, check.heuristic);
		
		assertEquals(15, solution.size(), "Solution path is wrong");
	}

}
