package appscripprep.javaprep.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	// Graph created with a weight value [Directed and Weighted graph]
	public void createGraph2(ArrayList<Edge> graph[]) {
		// First initialize ArrayList bcoz, array will be null not empty
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 7));

		graph[2].add(new Edge(2, 4, 3));

		graph[3].add(new Edge(3, 5, 1));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}

	public void dijkstra(ArrayList<Edge> graph[], boolean[] visit, int[] dist) {
		for (int i = 0; i < dist.length; i++) {
			if (i != 0) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		PriorityQueue<Pairs> pq = new PriorityQueue<>();
		pq.add(new Pairs(0, 0));
		while (!pq.isEmpty()) {
			Pairs curr = pq.remove();
			if (!visit[curr.getSrc()]) {
				visit[curr.getSrc()] = true;
				for (int i = 0; i < graph[curr.getSrc()].size(); i++) {
					Edge e = graph[curr.getSrc()].get(i);
					int src = e.getSrc();
					int dest = e.getDest();
					if (dist[src] + e.getWeight() < dist[dest]) {
						dist[dest] = dist[src] + e.getWeight();
						pq.add(new Pairs(dest, dist[dest]));
					}
				}
			}
		}

	}

	// Display
	public void display(int[] dist) {
		for (int d : dist) {
			System.out.print(d + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DijkstraAlgo algo = new DijkstraAlgo();
		int v = 6;
		ArrayList<Edge> graph[] = new ArrayList[v];
		int[] dist=new int[v];
		algo.createGraph2(graph);
		algo.dijkstra(graph, new boolean[v], dist);
		algo.display(dist);
	}

}
