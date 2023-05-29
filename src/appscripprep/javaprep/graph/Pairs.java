package appscripprep.javaprep.graph;

public class Pairs implements Comparable<Pairs>{
private int src;
private int dist;
public Pairs(int src, int dist) {
	super();
	this.src = src;
	this.dist = dist;
}
public int getSrc() {
	return src;
}
public void setSrc(int src) {
	this.src = src;
}
public int getDist() {
	return dist;
}
public void setDist(int dist) {
	this.dist = dist;
}
@Override
public int compareTo(Pairs o) {
	
	return this.dist-o.dist;
}

}
