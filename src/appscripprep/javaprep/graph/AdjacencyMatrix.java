package appscripprep.javaprep.graph;

public class AdjacencyMatrix {
	private int v;//No.of vertex
	private int e;//No.of edges
	private int[][] matrix;
	public AdjacencyMatrix(int noOfVertex) {
		this.v=noOfVertex;
		this.e=0;
		this.matrix=new int[v][v];
	}
	public void addEdge(int src,int dest) {
		matrix[src][dest]=1;
		matrix[dest][src]=1;//Because it is an undirected graph
		e++;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(v+" vertices, "+e+" edges "+"\n");
		for (int i = 0; i < v; i++) {
			sb.append(i+": ");
			for(int dest:matrix[i]) {
				sb.append(dest+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AdjacencyMatrix graph = new AdjacencyMatrix(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		System.out.println(graph);
		
	}

}
