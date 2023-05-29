package appscripprep.javaprep.tree;

import java.util.ArrayList;

public class MinHeap {
	ArrayList<Integer> list = new ArrayList<>();
	//Add
	public void add(int key) {
		//add
		list.add(key);
		int child=list.size()-1;
		int parent=(child-1)/2;
		while(list.get(child) < list.get(parent)) {
			swap(list, parent, child);
			child=parent;
			parent=(child-1)/2;
		}
		 
	}
	
	//remove
	public int remove() {
		int data=list.get(0);
		//swap first and last
		int child=list.size()-1;
		swap(list, 0, child);
		//delete last node
		list.remove(child);
		//heapify
		heapify(0);
		return data;
		
	}
	private void heapify(int rootIdx) {
		int left=2*rootIdx+1;
		int right=2*rootIdx+2;
		int minIdx=rootIdx;
		if(left < list.size() && list.get(minIdx) > list.get(left)) {
			minIdx=left;
		}
		if(right < list.size() && list.get(minIdx) > list.get(right)) {
			minIdx=right;
		}
		if(minIdx != rootIdx) {
			swap(list,  rootIdx,minIdx);
			heapify(minIdx);
		}
	}
	//peak
	public int peak() {
		return list.get(0);
	}
	//isEmpty
	public boolean isEmpty() {
		return list.size() == 0;
	}

	//Swap
	public void swap(ArrayList<Integer> list,int child,int parent) {
		int temp=list.get(parent);
		list.set(parent, list.get(child));
		list.set(child, temp);
	}
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.add(3);
		minHeap.add(4);
		minHeap.add(1);
		minHeap.add(5);
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.peak());
			minHeap.remove();
		}
	}
}
