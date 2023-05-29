package appscripprep.javaprep.graph;

import java.util.ArrayList;

public class BellmanFord {
	// Graph created with a weight value [Directed and Weighted graph]
	public void createGraph2(ArrayList<Edge> graph[]) {
		// First initialize ArrayList bcoz, array will be null not empty
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 2, -4));

		graph[2].add(new Edge(2, 3, 2));

		graph[3].add(new Edge(3, 4, 4));

		graph[4].add(new Edge(4, 1, -1));
	}

	// algo
	public void bellmanFord(ArrayList<Edge> graph[], int[] dist) {
		for (int i = 0; i < dist.length; i++) { // O(v)
			if (i != 0) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		// Run loop for V-1 [ O(V) ]
		for (int i = 0; i < graph.length - 1; i++) {
			//O(E)
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph[j].size(); k++) {
					Edge e = graph[j].get(k);
					int u = e.getSrc();
					int v = e.getDest();
					int wt = e.getWeight();
					if (dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
					}
				}
			}
		}
		
		// Run loop for V-1 times to detect negative weighted cycle graph[The sum of cycle weight is negative]
			//O(E)
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph[j].size(); k++) {
					Edge e = graph[j].get(k);
					int u = e.getSrc();
					int v = e.getDest();
					int wt = e.getWeight();
					if (dist[u] + wt < dist[v]) {
						System.out.println("Negative weighted cycle detected.");
						return;
					}
				}
			}
	}

	// display
	public void display(int[] dist) {
		for (int d : dist) {
			System.out.print(d + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int v=5;
		BellmanFord ford = new BellmanFord();
		ArrayList<Edge> graph[]=new ArrayList[v];
		int[] dist=new int[v];
		ford.createGraph2(graph);
		ford.bellmanFord(graph, dist);
		ford.display(dist);
	}

}
