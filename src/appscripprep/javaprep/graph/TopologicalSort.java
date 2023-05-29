package appscripprep.javaprep.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	//Created Directed cyclic graph
		public void createDirectedCyclicGraph(ArrayList<Edge> graph[]) {
			for (int i = 0; i < graph.length; i++) {
				graph[i]=new ArrayList<>();
			}
			graph[5].add(new Edge(5, 0));
			graph[5].add(new Edge(5, 2));
			
			graph[2].add(new Edge(2, 3));
			
			graph[3].add(new Edge(3, 1));
			
			
			graph[4].add(new Edge(4, 1));
			graph[4].add(new Edge(4, 0));
		}
		//Topological sort [----O(V+E)----------]
		private void topoSortUtil(ArrayList<Edge> graph[], int curr,boolean[] visit,Stack<Integer> stack) {
			visit[curr]=true;
			
			//Traverse each vertex which are not visited using DFS
			for (int i = 0; i < graph[curr].size(); i++) {
				int dest = graph[curr].get(i).getDest();
				if(! visit[dest]) {
					topoSortUtil(graph, dest, visit, stack);
				}
			}
			stack.push(curr);
		}
		//Topsort
		public void topSort(ArrayList<Edge> graph[]) {
			boolean[] visit=new boolean[graph.length];
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < visit.length; i++) {
				if(! visit[i]) {
					topoSortUtil(graph, i, visit, stack);
				}
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+ " ");
			}
		}
		
	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort();
		int v=6;
		ArrayList<Edge> graph[]=new ArrayList[v];
		ts.createDirectedCyclicGraph(graph);
		ts.topSort(graph);
	}

}
