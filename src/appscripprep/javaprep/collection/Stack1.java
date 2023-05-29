package appscripprep.javaprep.collection;

public class Stack1 {
	private Node head;
	private int size;
	
	
	public Stack1() {
		this.size=0;
	}
	//SIZE
	public int size() {
		return size;
	}
	//addFirst
	public void push(int data) {
		Node node = new Node(data);
		node.next=head;
		head=node;
		
		size++;
	}
	//peak
	public int peak() {
		return head.data;
	}
	//pop
	public int pop() {
		if(head != null) {
			int data =head.data;
			head=head.next;
			size--;
			return data;
		}
		return Integer.MIN_VALUE;
	}
	//isEmpty
	public boolean isEmpty() {
		return head == null;
	}

	private class Node {
		private int data;
		private Node next;

		public Node(int data,  Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Node(int data) {
			super();
			this.data = data;
		}

	}
}
