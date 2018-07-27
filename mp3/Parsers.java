package mp3;

import java.awt.List;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;

public class Parsers {
	/**
	 * This method returns a Graph after parsing a file with the corresponding
	 * graph data stored in the same format as the Enron dataset
	 * 
	 * @param fileName
	 *            is the name of the file with the dataset
	 * @param graphRep
	 *            is 1 for AdjacencyListGraph and 2 for AdjacencyMatrixGraph
	 * @return a Graph that represents the dataset in fileName and uses the
	 *         representation specified by graphRep
	 * @throws IOException
	 *             if there is a problem opening/reading data from the specified
	 *             file
	 */
	static public Graph parseEnronDataset(String fileName, int graphRep) throws IOException {
		if (graphRep == 1){
			//parse AdjacencyListGraph
			Graph graph = new AdjacencyListGraph();
			int c = 0;
			
			// Populate TreeMap
			String [] s = null;
			TreeMap<String, LinkedList<String>> map = new TreeMap<>();
			Scanner sc = new Scanner (new URL(fileName).openStream());
			LinkedList<String> verticies = new LinkedList<>();
			while (sc.hasNext())							
			{
				String word = sc.nextLine();
				s = word.split("\t");
				String key = s[0];
				String value = s[1];
				
				if (!verticies.contains(key)) {
					System.out.println(key);
					verticies.add(key);
					graph.addVertex(new Vertex(key));
				}
				
				if(!map.containsKey(s[0])) {
					LinkedList<String> list = new LinkedList<>();
					list.add(value);
					map.put(key, list);
				}
				else {
					LinkedList<String> list = new LinkedList<>(map.get(key));
					list.add(value);
					map.put(key, list);
				}
			}
			sc.close();
			
			for(Map.Entry<String, LinkedList<String>>  i : map.entrySet()) {
				
				Vertex a = new Vertex(i.getKey());
				LinkedList<String> strings = new LinkedList<>(i.getValue());
				
				for(Map.Entry<String, LinkedList<String>>  j : map.entrySet()) {
					LinkedList<String> edges = new LinkedList<>(j.getValue());
					Vertex b = new Vertex(j.getKey());
					
					if((!i.getKey().equals(j.getKey()) && edges.retainAll(strings) && !graph.edgeExists(a, b)) || i.getValue().equals(j.getValue()));{
						//System.out.println(i.getKey() + " : " + j.getKey());
					}
					
					
					if ((!a.equals(b) && edges.retainAll(strings) && !graph.edgeExists(a, b)) || i.getValue().equals(j.getValue())) {
						//graph.addEdge(a, b);
						//System.out.println("Edge from " + a + " to " + b);
						if (a.equals(b))
							break;
						else {
							graph.addEdge(a, b);
							System.out.println(a + " : " + b);
						}
					}
					else {
					}
				}
			}
			System.out.println("!!!!!!!!!!!!!!!!!!!");
			Algorithms alg = new Algorithms();
			System.out.println(Algorithms.diameter(graph));
		}
		else{
			//parse AdjacencyMatrixGraph
		}
		return null;
	}

	/**
	 * This method returns a Graph after parsing a file with the corresponding
	 * graph data stored in the same format as the Marvel dataset
	 * 
	 * @param fileName
	 *            is the name of the file with the dataset
	 * @param graphRep
	 *            is 1 for AdjacencyListGraph and 2 for AdjacencyMatrixGraph
	 * @return a Graph that represents the dataset in fileName and uses the
	 *         representation specified by graphRep
	 * @throws IOException
	 *             if there is a problem opening/reading data from the specified
	 *             file
	 */
	static public Graph parseMarvelDataset(String fileName, int graphRep) throws IOException {
		if (graphRep == 1){
			LinkedList<String> a = new LinkedList<>();
			a.add("1");
			a.add("2");
			a.add("3");
			a.add("4");
			
			LinkedList<String> b = new LinkedList<>();
			b.add("2");
			b.add("3");
			b.add("4");

			System.out.println(a.retainAll(b));
		}
		else{
			//parse AdjacencyMatrixGraph
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		parseEnronDataset("https://raw.githubusercontent.com/CPEN-221/f17-mp3-adamdxn/master/datasets/marvel.txt?token=AeRMt-YrjDqgkzVntWGQkKf1U8e9uWjwks5bJxDtwA%3D%3D",1);
	}
}
