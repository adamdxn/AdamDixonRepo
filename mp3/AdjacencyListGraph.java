package mp3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph implements Graph {
	
	private HashMap<Vertex, LinkedList<Vertex>> hm;
	private LinkedList<Vertex> verticies;
	
	
	AdjacencyListGraph(){
		HashMap<Vertex, LinkedList<Vertex>> hm = new HashMap<>();
		this.hm = hm;
		LinkedList<Vertex> v = new LinkedList<>();
		this.verticies = v;
	}
	
	/**
	 * Adds a vertex to the graph.
	 *
	 * Precondition: v is not already a vertex in the graph
	 */
	public void addVertex(Vertex v){
		if (!verticies.contains(v)) {
			hm.put(v, new LinkedList<Vertex>());
			verticies.add(v);
		}
	}

	/**
	 * Adds an edge from v1 to v2.
	 *
	 * Precondition: v1 and v2 are vertices in the graph
	 */
	public void addEdge(Vertex v1, Vertex v2){
		hm.get(v1).add(v2);
	}

	/**
	 * Check if there is an edge from v1 to v2.
	 *
	 * Precondition: v1 and v2 are vertices in the graph Postcondition: return
	 * true iff an edge from v1 connects to v2
	 */
	public boolean edgeExists(Vertex v1, Vertex v2){
		if(hm.get(v1).contains(v2))
			return true;
		return false;
	}

	/**
	 * Get an array containing all downstream vertices adjacent to v.
	 *
	 * Precondition: v is a vertex in the graph
	 * 
	 * Postcondition: returns a list containing each vertex w such that there is
	 * an edge from v to w. The size of the list must be as small as possible
	 * (No trailing null elements). This method should return a list of size 0
	 * iff v has no downstream neighbors.
	 */
	public List<Vertex> getDownstreamNeighbors(Vertex v){
		return hm.get(v);
		
	}

	/**
	 * Get an array containing all upstream vertices adjacent to v.
	 *
	 * Precondition: v is a vertex in the graph
	 * 
	 * Postcondition: returns a list containing each vertex u such that there is
	 * an edge from u to v. The size of the list must be as small as possible
	 * (No trailing null elements). This method should return a list of size 0
	 * iff v has no upstream neighbors.
	 */
	public List<Vertex> getUpstreamNeighbors(Vertex v){
		LinkedList<Vertex> vList = new LinkedList<>();
		LinkedList<Vertex> returnList = new LinkedList<>();
		
		for (Map.Entry<Vertex, LinkedList<Vertex>> e : hm.entrySet()){
			vList = e.getValue();
			for(int i = 0; i < vList.size(); i++){
				if(vList.get(i).equals(v))
					returnList.add(e.getKey());
			}
		}
		
		return returnList;
		
	}

	/**
	 * Get all vertices in the graph.
	 *
	 * Postcondition: returns a list containing all vertices in the graph. This
	 * method should return a list of size 0 iff the graph has no vertices.
	 */
	public List<Vertex> getVertices(){
		if (verticies.size() > 0)
			return verticies;
		else
			return new LinkedList<Vertex>();	
	}
	
	public void printGraph(){
		for(Map.Entry<Vertex, LinkedList<Vertex>> e : hm.entrySet()){
			String v = e.getKey().getLabel();
			System.out.println(v + " : " + e.getValue());
		}
	}
	public static void main(String[] args) {
		Graph graph = new AdjacencyListGraph();
		graph.addVertex(new Vertex("0"));
		graph.addVertex(new Vertex("1"));
		graph.addVertex(new Vertex("2"));
		graph.addVertex(new Vertex("3"));
		
		graph.addEdge(new Vertex("0"), new Vertex("1"));
		System.out.println(graph.edgeExists(new Vertex("0"), new Vertex("1")));

	}
}