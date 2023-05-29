package appscripprep.javaprep.graph;

import java.util.ArrayList;

public class PrintAllPath {

	public static void main(String[] args) {
		AdjacencyList gp = new AdjacencyList();
		int v=7;
		ArrayList<Edge> graph[] =new ArrayList[v];
		gp.createGraph4(graph);
		gp.printAllPath(graph, 0, new boolean[v], "0", 5);
	}

}
