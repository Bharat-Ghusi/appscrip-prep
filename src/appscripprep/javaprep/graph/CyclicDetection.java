package appscripprep.javaprep.graph;

import java.util.ArrayList;

public class CyclicDetection {
	
	//1:Created Directed cyclic graph
	public void createDirectedCyclicGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1));
		
		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 4));
		
		graph[4].add(new Edge(4, 2));
	}
	//Cycle detection in directed graph
		public boolean isCyclic(ArrayList<Edge> graph[],int curr,boolean[] visit,boolean[] stack) {
			visit[curr]=true;
			stack[curr]=true;
			
			//Add all neighbors
			for (int i = 0; i < graph[curr].size(); i++) {
				 int dest = graph[curr].get(i).getDest();
				 if(stack[dest] ) { //Cycle check, true means there is a cycle
					 return true;
				 }
				 else if(! visit[dest] && isCyclic(graph, dest, visit, stack)) {
					 return true;
				 }
			}
			stack[curr]=false;//Make recursive call log false so that in next route/path 
			return false;//THere is no cycle
			//visit[] to traverse each vertex
			//stack[] to store all visited vortex during recursion
			
		}
		//2: Created undirected cycle graph
		public void createUndirectedCyclicGraph(ArrayList<Edge> graph[]) {
			for (int i = 0; i < graph.length; i++) {
				graph[i]=new ArrayList<>();
			}
			graph[0].add(new Edge(0, 1));
			graph[0].add(new Edge(0, 4));
			
			graph[1].add(new Edge(1, 0));
			graph[1].add(new Edge(1, 2));
			graph[1].add(new Edge(1, 4));
			
			graph[2].add(new Edge(2, 1));
			graph[2].add(new Edge(2, 3));
//			
			graph[3].add(new Edge(3, 2));
			
			graph[4].add(new Edge(4, 0));
			graph[4].add(new Edge(4, 1));  
			graph[4].add(new Edge(4, 5));
			
			graph[5].add(new Edge(5, 4));
		}
		//Detect cycle for undirected graph [O(V+E)]
		public boolean isCyclic(ArrayList<Edge> graph[],int curr,boolean[] visit,int parent) {
			visit[curr]=true;
			//traverse each vertex
			for (int i = 0; i < graph[curr].size(); i++) {
				int dest = graph[curr].get(i).getDest();
				if(visit[dest] && dest!=parent) { //Dest is visited by other vertex and it's not his parent. Means, it's a cycle
					return true;
				}
//				else if(visit[dest] && dest == parent) {
//					//Do nothing
//				}
				else if(! visit[dest]) { //Not visited yet
					if(isCyclic(graph, dest, visit, curr)) {
						return true;
					}
				}
			}
			
			return false;
			
		}

	public static void main(String[] args) {
//		//-------------Cyclic detection in directed graph-------------
//		CyclicDetection c = new CyclicDetection();
//		int v=5;
//		ArrayList<Edge> graph[] =new ArrayList[v];
//		c.createDirectedCyclicGraph(graph);
//		boolean[] visit=new boolean[v];
//		boolean[] stack=new boolean[v];
//		for (int i = 0; i < visit.length; i++) {
//			if(! visit[i] ) {
//				boolean isTrue=c.isCyclic(graph, i, visit, stack);
//				if(isTrue) {
//					System.out.println(isTrue);
//					break;
//				}
//			}
//		}
//		
		
		//-------------Cyclic detection in undirected graph-------------
		CyclicDetection c = new CyclicDetection();
		int v=6;
		ArrayList<Edge> graph[] =new ArrayList[v];
		c.createUndirectedCyclicGraph(graph);;
		boolean[] visit=new boolean[v];
		System.out.println(c.isCyclic(graph, 0, visit, -1));
		
		}
	}


