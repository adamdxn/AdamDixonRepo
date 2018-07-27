package mp3;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class AdjacencyListGraphTest {

	@Test
	public void test0(){
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
	}
	
	@Test
	public void test1(){
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		
		graph.addEdge(v0, v4);
		graph.addEdge(v0, v3);
		graph.addEdge(v1, v4);
		graph.addEdge(v2, v3);
		graph.addEdge(v3, v0);
		
	}
	
	@Test
	public void test2(){
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
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
		
		
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addVertex(v7);
		graph.addVertex(v8);
		graph.addVertex(v9);
		graph.addVertex(v10);

		
		graph.addEdge(v0, v1);
		graph.addEdge(v0, v4);
		
		graph.addEdge(v1, v6);
		graph.addEdge(v1, v2);
		
		graph.addEdge(v2, v4);

		graph.addEdge(v3, v2);
		graph.addEdge(v3, v4);
		
		graph.addEdge(v4, v10);
		
		graph.addEdge(v5, v7);
		
		graph.addEdge(v6, v5);
		graph.addEdge(v6, v7);
		graph.addEdge(v6, v8);
		
		graph.addEdge(v7, v8);
		
		graph.addEdge(v8, v9);
		
		graph.addEdge(v9, v8);
		graph.addEdge(v9, v3);
		
		LinkedList<Vertex> v = new LinkedList<>();
		v.add(v5);
		v.add(v7);
		v.add(v8);
		
		assertEquals(v, graph.getDownstreamNeighbors(v6));
	}
	
	@Test
	public void test3(){
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
		graph.addVertex(new Vertex("0"));
		graph.addVertex(new Vertex("1"));
		graph.addVertex(new Vertex("2"));
		graph.addVertex(new Vertex("3"));
		graph.addVertex(new Vertex("4"));
		graph.addVertex(new Vertex("5"));
		graph.addVertex(new Vertex("6"));
		graph.addVertex(new Vertex("7"));
		graph.addVertex(new Vertex("8"));
		graph.addVertex(new Vertex("9"));
		graph.addVertex(new Vertex("10"));

		
		LinkedList<Vertex> v = new LinkedList<>();
		for(int i = 0; i < 11; i++){
			v.add(new Vertex(Integer.toString(i)));
			
		}
		
		assertEquals(v, graph.getVertices());
	}
	
	@Test
	public void test4(){
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
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
		
		
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addVertex(v7);
		graph.addVertex(v8);
		graph.addVertex(v9);
		graph.addVertex(v10);

		
		graph.addEdge(v0, v1);
		graph.addEdge(v0, v4);
		
		graph.addEdge(v1, v6);
		graph.addEdge(v1, v2);
		
		graph.addEdge(v2, v4);

		graph.addEdge(v3, v2);
		graph.addEdge(v3, v4);
		
		graph.addEdge(v4, v10);
		
		graph.addEdge(v5, v7);
		
		graph.addEdge(v6, v5);
		graph.addEdge(v6, v7);
		graph.addEdge(v6, v8);
		
		graph.addEdge(v7, v8);
		
		graph.addEdge(v8, v9);
		
		graph.addEdge(v9, v8);
		graph.addEdge(v9, v3);
		
		assertEquals(new LinkedList<Vertex>(), graph.getDownstreamNeighbors(v10));
	}
	
	@Test
	public void test5(){
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
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
		
		
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addVertex(v7);
		graph.addVertex(v8);
		graph.addVertex(v9);
		graph.addVertex(v10);

		
		graph.addEdge(v0, v1);
		graph.addEdge(v0, v4);
		
		graph.addEdge(v1, v6);
		graph.addEdge(v1, v2);
		
		graph.addEdge(v2, v4);

		graph.addEdge(v3, v2);
		graph.addEdge(v3, v4);
		
		graph.addEdge(v4, v10);
		
		graph.addEdge(v5, v7);
		
		graph.addEdge(v6, v5);
		graph.addEdge(v6, v7);
		graph.addEdge(v6, v8);
		
		graph.addEdge(v7, v8);
		
		graph.addEdge(v8, v9);
		
		graph.addEdge(v9, v8);
		graph.addEdge(v9, v3);
		
		
		LinkedList<Vertex> v = new LinkedList<>();
		v.add(v0);
		v.add(v2);
		v.add(v3);
		
		assertEquals(v, graph.getUpstreamNeighbors(v4));
	}
	
	
}
