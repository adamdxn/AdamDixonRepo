package mp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Algorithms {

	/**
	 * *********************** Algorithms ****************************
	 *
	 * Please see the README for this machine problem for a more detailed
	 * specification of the behavior of each method that one should implement.
	 */

	/**
	 * This is provided as an example to indicate that this method and other methods
	 * should be implemented here.
	 *
	 * Given a graph and two verticies, return the shortest distance between the two
	 * points. Each edge has weight 1 and this is a directed graph. If there is no
	 * path from a to b then return -1
	 *
	 * @param graph
	 * @param a
	 * @param b
	 * @return the shortest distance from a to b
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		Queue<Vertex> q = new LinkedList<>();
		TreeMap<Integer, Integer> distanceMap = new TreeMap<>();
		ArrayList<Vertex> verticies = new ArrayList<>(graph.getVertices());
		// initialize all distances to 0
		for (int i = 0; i < verticies.size(); i++) {
			distanceMap.put(i, 0);
		}

		LinkedList<Vertex> visited = new LinkedList<>();
		q.add(a);

		// start BFS
		while (!q.isEmpty()) {

			// mark as visited
			if (!visited.contains(q.peek())) {
				visited.add(q.peek());
			}

			// enqueue DSV
			Vertex curVer = q.peek();
			LinkedList<Vertex> DSV = new LinkedList<>(graph.getDownstreamNeighbors(q.poll()));
			for (int j = 0; j < DSV.size(); j++) {
				if (!visited.contains(DSV.get(j))) {
					q.add(DSV.get(j));
					visited.add(DSV.get(j));
					distanceMap.put(verticies.indexOf(DSV.get(j)), distanceMap.get(verticies.indexOf(curVer)) + 1);
				}
			}

		}
		return distanceMap.get(verticies.indexOf(b));
	}

	public static TreeMap<Integer, Integer> getDistances(Graph graph, Vertex a) {
		Queue<Vertex> q = new LinkedList<>();
		TreeMap<Integer, Integer> distanceMap = new TreeMap<>();
		ArrayList<Vertex> verticies = new ArrayList<>(graph.getVertices());
		// initialize all distances to 0
		for (int i = 0; i < verticies.size(); i++) {
			distanceMap.put(i, 0);
		}

		LinkedList<Vertex> visited = new LinkedList<>();
		q.add(a);

		// start BFS
		while (!q.isEmpty()) {

			// mark as visited
			if (!visited.contains(q.peek())) {
				visited.add(q.peek());
			}

			// enqueue DSV
			Vertex curVer = q.peek();
			LinkedList<Vertex> DSV = new LinkedList<>(graph.getDownstreamNeighbors(q.poll()));
			for (int j = 0; j < DSV.size(); j++) {
				if (!visited.contains(DSV.get(j))) {
					q.add(DSV.get(j));
					visited.add(DSV.get(j));
					distanceMap.put(verticies.indexOf(DSV.get(j)), distanceMap.get(verticies.indexOf(curVer)) + 1);
				}
			}

		}
		return distanceMap;
	}

	private static int eccentricity(Graph graph, Vertex v) {
		int eccentricity = 0;

		TreeMap<Integer, Integer> map = new TreeMap<>(getDistances(graph, v));

		for (Integer value : map.values()) {
			if (value != 0)
				eccentricity += value;
		}
		return eccentricity;
	}

	/**
	 * Perform a complete depth first search of the given graph. Start with the
	 * search at each vertex of the graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list of elements seen by
	 * starting a DFS at a specific vertex of the graph (the number of elements in
	 * the returned set should correspond to the number of graph vertices).
	 *
	 * @param
	 * @return
	 */
	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		Set<List<Vertex>> set = new HashSet<>();
		LinkedList<Vertex> verticies = new LinkedList<>(graph.getVertices());
		Stack<Vertex> s = new Stack<>();

		if (verticies.size() == 0) {
			return set;
		}

		for (int i = 0; i < verticies.size(); i++) {
			LinkedList<Vertex> visited = new LinkedList<>();

			s.push(verticies.get(i));
			visited.add(verticies.get(i));

			// start DFS
			while (!s.isEmpty()) {
				Vertex v = s.peek();
				Vertex nextVert = getUnVisitedVertex(graph.getDownstreamNeighbors(v), visited);
				if (nextVert != null) {
					visited.add(nextVert);
					s.push(nextVert);
				} else {
					s.pop();
				}
			}
			set.add(visited);
		}
		return set;

	}

	private static Vertex getUnVisitedVertex(List<Vertex> list, List<Vertex> visited) {
		for (int i = 0; i < list.size(); i++) {
			if (!visited.contains(list.get(i))) {
				return list.get(i);
			}
		}
		return null;
	}

	/**
	 * Perform a complete breadth first search of the given graph. Start with the
	 * search at each vertex of the graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list of elements seen by
	 * starting a BFS at a specific vertex of the graph (the number of elements in
	 * the returned set should correspond to the number of graph vertices).
	 *
	 * @param graph
	 * @return set of paths taken by the BFS starting at each node
	 */
	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		Set<List<Vertex>> set = new HashSet<>();
		LinkedList<Vertex> verticies = new LinkedList<>(graph.getVertices());
		Queue<Vertex> q = new LinkedList<>();

		if (verticies.size() == 0) {
			return set;
		}

		for (int i = 0; i < verticies.size(); i++) {

			LinkedList<Vertex> visited = new LinkedList<>();
			Vertex startVertex = verticies.get(i);
			q.add(verticies.get(i));
			visited.add(startVertex);

			// start BFS
			while (!q.isEmpty()) {

				// mark as visited
				if (!visited.contains(q.peek()))
					visited.add(q.peek());

				// enqueue DSV
				LinkedList<Vertex> DSV = new LinkedList<>(graph.getDownstreamNeighbors(q.poll()));
				for (int j = 0; j < DSV.size(); j++) {
					if (!visited.contains(DSV.get(j))) {
						q.add(DSV.get(j));
						visited.add(DSV.get(j));
					}
				}

			}
			set.add(visited);
			visited.clear();
		}
		return set;
	}

	/**
	 * You should write the spec for this method
	 */
	public static Vertex center(Graph graph) {
		ArrayList<Vertex> verticies = new ArrayList<>(graph.getVertices());
		int min = eccentricity(graph, verticies.get(1));
		Vertex vert = verticies.get(0);
		// find max eccentricity
		for (int i = 0; i < verticies.size(); i++) {
			int curr = eccentricity(graph, verticies.get(i));
			if (curr > min) {
				vert = verticies.get(i);
				min = curr;
			}
		}

		return vert;
	}

	/**
	 * You should write the spec for this method
	 */
	public static int diameter(Graph graph) {
		ArrayList<Vertex> verticies = new ArrayList<>(graph.getVertices());
		int max = -1;

		// forwards
		for (int i = 0; i < verticies.size(); i++) {
			for (int j = 0; j < verticies.size() - i; j++) {
				System.out.println(verticies.get(i).getLabel() + " : " + verticies.get(j).getLabel());
				System.out.println(shortestDistance(graph, verticies.get(i), verticies.get(j)));
				if (shortestDistance(graph, verticies.get(i), verticies.get(j)) > max) {
					max = shortestDistance(graph, verticies.get(i), verticies.get(j));
				}
			}
		}

		// backwards
//		for (int i = verticies.size() - 1; i > 0; i--) {
//			for (int j = 0; j < verticies.size(); j++) {
//				if (shortestDistance(graph, verticies.get(i), verticies.get(j)) > max) {
//					max = shortestDistance(graph, verticies.get(i), verticies.get(j));
//				}
//			}
//		}
		return max;
	}

	/**
	 * You should write the spec for this method
	 */
	public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {
		LinkedList<Vertex> vA = new LinkedList<>(graph.getUpstreamNeighbors(a));
		LinkedList<Vertex> vB = new LinkedList<>(graph.getUpstreamNeighbors(b));
		LinkedList<Vertex> retList = new LinkedList<>();

		if (vA.size() >= vB.size()) {
			for (int i = 0; i < vA.size(); i++) {
				if (vA.contains(vB.get(i)))
					retList.add(vB.get(i));
			}
		} else {
			for (int i = 0; i < vB.size(); i++) {
				if (vB.contains(vA.get(i)))
					retList.add(vA.get(i));
			}
		}
		return retList;
	}

	/**
	 * You should write the spec for this method
	 */
	public static List<Vertex> commonDownstreamVertices(Graph graph, Vertex a, Vertex b) {
		LinkedList<Vertex> vA = new LinkedList<>(graph.getDownstreamNeighbors(a));
		LinkedList<Vertex> vB = new LinkedList<>(graph.getDownstreamNeighbors(b));
		LinkedList<Vertex> retList = new LinkedList<>();

		if (vA.size() >= vB.size()) {
			for (int i = 0; i < vA.size(); i++) {
				if (vA.contains(vB.get(i)))
					retList.add(vB.get(i));
			}
		} else {
			for (int i = 0; i < vB.size(); i++) {
				if (vB.contains(vA.get(i)))
					retList.add(vA.get(i));
			}
		}
		return retList;
	}

	public static void main(String[] args) {
		Graph graph = new AdjacencyListGraph();

		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		Vertex v8 = new Vertex("8");
		Vertex v9 = new Vertex("9");
		Vertex v10 = new Vertex("10");
		Vertex v11 = new Vertex("11");

		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);

		graph.addEdge(v5, v0);
		graph.addEdge(v0, v1);
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v3, v4);

		LinkedList<Vertex> verticies = new LinkedList<>(graph.getVertices());

		
		System.out.println(depthFirstSearch(graph));
		
	}

}