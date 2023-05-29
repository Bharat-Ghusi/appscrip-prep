package appscripprep.javaprep.collection;

public class LL {
	private Node head;
	private Node tail;
	private int size;
	
	public LL() {
		size=0;
	}
	
	

	//addlast
	public void addFirst(int data) {
		Node node=new Node(data);
		node.next=head;
		node.pre=null;
		if(head != null) {
			head.pre=node;
		}
		head=node;
		if(tail == null) {
			tail=head;
		}
		
		size++;
	}
	//Display
	public void display() {
		Node node=head;
		while(node != null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	
	//Add at specific index
	public void addAt(int index,int data) {
		if(head.next== null ) {
			 addFirst(data);
			 return;
		}
		if(index >= size) {
			addLast(data);
		}
		Node node = new Node(data);
		Node preTemp=getNode(index);
		node.next=preTemp.next;
		preTemp.next.pre=node;
		preTemp.next=node;
		node.pre=preTemp;
		size++;
		
		
	}
	public void addLast(int data) {
		if(tail == null) {
			addFirst(data);
			return;
		}
		
		Node node = new Node(data);
		tail.next=node;
		node.pre=tail;
		tail=node;
		size++;
	}



	//getNode
	public Node	getNode(int index) {
		Node node=head;
		
		while(node != null && index >=0 ) {
			if(index == 0) {
				return node.pre;
			}
			node=node.next;
			index--;
		}
		return node;
	}
	
	//gethHead
	public int getHead() {
		return head.data;
	}
	//getTail
	public int getTail() {
		return tail.data;
	}
	
	private  class Node {
		int data;
		private Node next;
		private Node pre;
		public Node(int data, Node next, Node pre) {
			super();
			this.data = data;
			this.next = next;
			this.pre = pre;
		}
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
}
