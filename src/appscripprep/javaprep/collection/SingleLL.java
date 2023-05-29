package appscripprep.javaprep.collection;


public class SingleLL {
	private Node head;
	private Node tail;
	private int size;
	
	public SingleLL() {
		this.size=0;
	}
	//AddFirst
	public void addFirst(int data) {
		Node node = new Node(data);
		node.next=head;
		head=node;
		if(tail == null) {
			tail=head;
		}
		size++;
	}
	//display
	public void display() {
		Node node=head;
		while(node != null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
		
	}
	//Head
	public int getHeadValue() {
		return head.data;
	}
	//Tail
	public int getTailValue() {
		return tail.data;
	}
	//Head node
	public Node getHeadNode() {
		return head;
	}
	//Reverse
	public void reverse(Node node) {
		if(node == null)return;
			reverse(node.next);
			System.out.print(node.data+" ");
		
	}
	
	private class Node{
		private int data;
		private Node next;
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		SingleLL list = new SingleLL();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.display();
		System.out.println("Head: "+list.getHeadValue());
		System.out.println("Tail: "+list.getTailValue());
		list.reverse(list.getHeadNode());
		System.out.println();
		
	}

}
