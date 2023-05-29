package appscripprep.javaprep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Edge
	 class Edge {
		private int src;
		private int dest;
		private int weight;

		public Edge(int src, int dest) {
			super();
			this.src = src;
			this.dest = dest;
		}

		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public int getSrc() {
			return src;
		}

		public void setSrc(int src) {
			this.src = src;
		}

		public int getDest() {
			return dest;
		}

		public void setDest(int dest) {
			this.dest = dest;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
		
	}
public class AdjacencyList {

	

	// Graph created without any weight[Undirected graph]
	public void createGraph1(ArrayList<Edge> graph[]) {
		// First initialize ArrayList bcoz, array will be null not empty
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 2));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 2));
		graph[3].add(new Edge(3, 2));
	}
	//DEMO GRAPH
	// Graph created without any weight[Undirected graph]
	public void createGraph4(ArrayList<Edge> graph[]) {
		// First initialize ArrayList bcoz, array will be null not empty
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 3));
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));
		
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
		
		graph[6].add(new Edge(6, 5));
	}
	
	// Graph created with a weight value [Undirected and Weighted graph]
	public void createGraph2(ArrayList<Edge> graph[]) {
		// First initialize ArrayList bcoz, array will be null not empty
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 2, 2));

		graph[1].add(new Edge(1, 2, 10));
		graph[1].add(new Edge(1, 3, 0));

		graph[2].add(new Edge(2, 0, 2));
		graph[2].add(new Edge(2, 1, 10));
		graph[2].add(new Edge(2, 3, -1));

		graph[3].add(new Edge(3, 2, 0));
		graph[3].add(new Edge(3, 2, -1));
	}
	// Create a graph[Refer to BFS ] and created edge from user input
	public void createGraph3(ArrayList<ArrayList<Edge>> graph) {

		Scanner sc = new Scanner(System.in);
		String isTrue="Yes";
		int i=0;
		while(isTrue.equalsIgnoreCase("Yes")) {
			graph.add(new ArrayList<Edge>());//Initialize list
			
			ArrayList<Edge> list=getEdges(); //edge details
			for(Edge e:list) { //No.of edges from a vertex
				graph.get(i).add(e);
			}
			System.out.println("Want to add more vertex, Enter Yes/No");
			isTrue=sc.nextLine();
			i++;//vertex index
		}
	}
	
	//method to take edges details from input
	private ArrayList<Edge> getEdges() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Edge> list = new ArrayList<>();
		
		int isTrue=1;
		while(isTrue == 1) {
			System.out.println("Enter vertex edges in terms of src and dest");
			int src=sc.nextInt();
			int dest=sc.nextInt();
			list.add(new Edge(src, dest));
			System.out.println("Want to add more edges, Enter 0 for NO and 1 for YES ");
			isTrue=sc.nextInt();
		}
		return list;
	}
	
	//BFS for connected graph
	//Time complexity: O(V+E)
	public void bfs(ArrayList<Edge> graph[]) {
		Queue<Integer> queue = new LinkedList<>();
		boolean visitLog[] =new boolean[graph.length]; //size== No. of vertices
		queue.add(0);
		while(! queue.isEmpty()) {
			int curr=queue.remove();
			if(visitLog[curr] == false) {
				System.out.print(curr+", ");
				visitLog[curr]=true;
				for (int i = 0; i < graph[curr].size(); i++) {
					Edge edge = graph[curr].get(i);
					queue.add(edge.getDest());
				}
			}
					
		}
		
	}
	//BFS for disconnected graph
	//Time complexity: O(V+E)
	public void bfs1(ArrayList<Edge> graph[],boolean[] visitLog,int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while(! queue.isEmpty()) {
			int curr=queue.remove();
			if(visitLog[curr] == false) {
				System.out.print(curr+", ");
				visitLog[curr]=true;
				for (int i = 0; i < graph[curr].size(); i++) {
					Edge edge = graph[curr].get(i);
					queue.add(edge.getDest());
				}
			}
			
		}
		
	}
	//DFS for connected/disconnected graph
	//Time complexity: O(V+E)
	public void dfs(ArrayList<Edge> graph[],boolean[] visitLog,int curr) {
		System.out.print(curr+", ");
		visitLog[curr]=true;
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge edge = graph[curr].get(i);
			int dest=edge.getDest();
			if(visitLog[dest] == false) {
				dfs(graph, visitLog, dest);
			}
		}
	}
	//Print all path from source to destination
	public void printAllPath(ArrayList<Edge> graph[],int curr,boolean[] visitLog,String path,int target) {
		//Base case
		if(curr == target) {
			System.out.println(path.toString());
			return;
		}
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge edge = graph[curr].get(i);
			int dest=edge.getDest();
			if(! visitLog[dest]) {
				visitLog[curr]=true;
				printAllPath(graph, dest, visitLog, path+dest, target);
				visitLog[curr]=false;
			}
		}
	}
	
	

	public static void main(String[] args) {
//		int v = 4; // Number of vortex.
//		ArrayList<Edge> graph[] = new ArrayList[4];
//		AdjacencyList gp = new AdjacencyList();
//		gp.createGraph1(graph);
//
//		// Print Neighbors of a specific node.
//		for (int i = 0; i < graph[2].size(); i++) {
//			Edge edge = graph[2].get(i);
//			System.out.print(edge.dest + " ");
//		}
//		
//		System.out.println();
//
		
//		//----------Created weighted graph-----------
//		gp.createGraph2(graph);
//
//		// Print Neighbors of a specific node.
//		for (int i = 0; i < graph[2].size(); i++) {
//			Edge edge = graph[2].get(i);
//			System.out.print(edge.dest+", "+edge.weight+"	");
//		}
//		System.out.println();
			
//		//---------COde for creating graph according to user input----------
//		ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
//		AdjacencyList gp = new AdjacencyList();
//		gp.createGraph3(graph);
//		//print neighbors of specific vertex
//		for (int i = 0; i < graph.get(2).size(); i++) {
//			Edge edge = graph.get(2).get(i);
//			System.out.print(edge.getDest()+", ");
//		}
//		
		//-------BFS for connected graph-----------
//		int v=7;
//		ArrayList<Edge> graph[] =new ArrayList[v];
//		AdjacencyList gp = new AdjacencyList();
//		gp.createGraph4(graph);
//		gp.bfs(graph);
//		System.out.println();
//		//-------BFS for disconnected graph-----------
//		boolean visitLog[] =new boolean[v]; //size== No. of vertices
//		for (int i = 0; i < visitLog.length; i++) {
//			if(visitLog[i] == false) {
//				gp.bfs1(graph, visitLog, i);
//			}
//		}
//		System.out.println();
//		//-------BFS for connected graph-----------
//		boolean visitLog1[] =new boolean[v];
////		gp.dfs(graph, visitLog1,0 );
		//-------BFS for disconnected graph-----------
//		for (int i = 0; i < visitLog1.length; i++) {
//			if(visitLog1[i] == false) {
//				gp.dfs(graph, visitLog1, i);
//			}
//		}
		
	}
	
	
}
