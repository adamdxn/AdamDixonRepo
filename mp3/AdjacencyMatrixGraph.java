package mp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

	private ArrayList<ArrayList<Boolean>> matrix;
	private LinkedList<Vertex> verticies;
	private HashMap<Vertex, Integer> position;

	AdjacencyMatrixGraph() {
		this.matrix = new ArrayList<ArrayList<Boolean>>();
		this.verticies = new LinkedList<Vertex>();
		this.position = new HashMap<Vertex, Integer>();
	}

	/**
	 * Adds a vertex to the graph.
	 *
	 * Precondition: v is not already a vertex in the graph
	 */
	public void addVertex(Vertex v) {
		verticies.add(v);
		
		position.put(v, verticies.size() - 1);

		// first entry in matrix
		if (verticies.size() == 1) {
			ArrayList<Boolean> b = new ArrayList<>();
			b.add(false);
			matrix.add(b);
			return;
		}

		ArrayList<Boolean> b = new ArrayList<>();
		// populate matrix with extra false column
		for (int i = 0; i < verticies.size() - 1; i++) {
			matrix.get(i).add(false);
			b.add(false);
		}
		b.add(false);
		// add new row
		matrix.add(b);
	}

	/**
	 * Adds an edge from v1 to v2.
	 *
	 * Precondition: v1 and v2 are vertices in the graph
	 */
	public void addEdge(Vertex v1, Vertex v2) {

		int row = getIndex(v1);
		int column = getIndex(v2);

		ArrayList<Boolean> b = new ArrayList<>(matrix.get(row));
		b.set(column, true);
		matrix.set(row, b);

	}

	/**
	 * Check if there is an edge from v1 to v2.
	 *
	 * Precondition: v1 and v2 are vertices in the graph Postcondition: return true
	 * iff an edge from v1 connects to v2
	 */
	public boolean edgeExists(Vertex v1, Vertex v2) {
		return matrix.get(getIndex(v1)).get(getIndex(v2));
	}

	/**
	 * Get an array containing all downstream vertices adjacent to v.
	 *
	 * Precondition: v is a vertex in the graph
	 * 
	 * Postcondition: returns a list containing each vertex w such that there is an
	 * edge from v to w. The size of the list must be as small as possible (No
	 * trailing null elements). This method should return a list of size 0 iff v has
	 * no downstream neighbors.
	 */
	public List<Vertex> getDownstreamNeighbors(Vertex v) {
		LinkedList<Vertex> DSV = new LinkedList<>();

		int row = getIndex(v);
		ArrayList<Boolean> areDownstream = new ArrayList<>(matrix.get(row));

		for (int i = 0; i < areDownstream.size(); i++) {
			if (areDownstream.get(i))
				DSV.add(verticies.get(i));
		}

		return DSV;
	}

	/**
	 * Get an array containing all upstream vertices adjacent to v.
	 *
	 * Precondition: v is a vertex in the graph
	 * 
	 * Postcondition: returns a list containing each vertex u such that there is an
	 * edge from u to v. The size of the list must be as small as possible (No
	 * trailing null elements). This method should return a list of size 0 iff v has
	 * no upstream neighbors.
	 */
	public List<Vertex> getUpstreamNeighbors(Vertex v) {

		if (verticies.size() == 0)
			return new LinkedList<Vertex>();

		LinkedList<Vertex> USV = new LinkedList<>();

		int column = getIndex(v);

		if (column == -1)
			return new LinkedList<Vertex>();

		for (int i = 0; i < verticies.size(); i++) {
			if (matrix.get(i).get(column))
				USV.add(verticies.get(i));
		}

		return USV;
	}

	/**
	 * Get all vertices in the graph.
	 *
	 * Postcondition: returns a list containing all vertices in the graph. This
	 * method should return a list of size 0 iff the graph has no vertices.
	 */
	public List<Vertex> getVertices() {
		if (verticies.size() > 0)
			return verticies;
		else
			return new LinkedList<Vertex>();
	}

	public void printMatrix() {
		String s = "";
		for (int i = 0; i < matrix.size(); i++) {
			ArrayList<Boolean> b = new ArrayList<>();
			b = matrix.get(i);
			for (int j = 0; j < b.size(); j++) {
				s += " " + b.get(j);
			}
			System.out.println(s);
			s = "";
		}
	}

	public int getIndex(Vertex v) {
		return position.get(v);
	}
}
