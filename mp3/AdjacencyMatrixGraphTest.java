package mp3;
import static org.junit.Assert.*;

import org.junit.Test;

public class AdjacencyMatrixGraphTest {
	@Test
	public void test0(){
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph();
		
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");

		
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);


		graph.addEdge(v0, v1);
		graph.addEdge(v0, v2);
		graph.addEdge(v0, v3);
		graph.addEdge(v0, v4);
		
		graph.addEdge(v2, v1);
		
		graph.addEdge(v1, v5);
		graph.addEdge(v1, v5);
		graph.addEdge(v5, v1);
		graph.addEdge(v2, v4);

		
		graph.printMatrix();
		
		System.out.println(graph.getDownstreamNeighbors(v0));
		System.out.println(graph.getUpstreamNeighbors(v1));

	}
}
