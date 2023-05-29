package appscripprep.datastructurevid;

public class SingleLinkedList {
	private Node head=null;
	private Node tail=null;
	private int size;
	
	
	
	public SingleLinkedList() {
		this.size=0;
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
	
	//Add
	public void add(int data) {
		Node node = new Node(data);
		if(head == null) {
			head=node;
			tail=head;
		}
		else {
			tail.next=node;
			tail=node;
		}
		size++;
	}
	//PrintForward
	public void printForward() {
		Node temp=head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	//printBackWard
	public void printBackward(Node node) {
		Node curr=node;
		if(curr == null) {
			return ;
		}
		printBackward(node.next);
		System.out.print(node.data+" ");
	}
	//getHead
	public Node getHead() {
		return head;
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.printForward();
		list.printBackward(list.getHead());
	}

}
