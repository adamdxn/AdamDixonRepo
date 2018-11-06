package chess;

import java.util.LinkedList;
/*
 * Each Node contains a board configuration. You will be able to determine the heuristic 
 * value of the Node to help with the implementation of the alpha beta pruning algorithm
 */
public class Node {
	LinkedList<Node> children;
	private Board configuration;
	
	Node(Board configuration){
		this.children = new LinkedList<Node>();
		this.configuration = configuration;
	}
	/*
	 * Heuristic evaluation function
	 */
	public int evaluation() {
		return 0;
	}
}
