package appscripprep.datastructurevid;


public class SentinelList {
	private Node head = new Node();
	private Node tail = new Node();

	

	public SentinelList() {
		head.next=tail;
		tail.prev=head;
	}
	



	private class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node(int data) {
			super();
			this.data = data;
		}

		public Node() {
		}

	}
	
	//AddLast
	public void addLast(int data) {
		Node node = new Node(data);
		node.next=tail;
		node.prev=tail.prev;
		
		this.tail.prev.next=node;
		this.tail.prev=node;
				
	}
	//AddFront
	public void addFront(int data) {
		Node node = new Node(data);
		node.prev=head;
		node.next=head.next;
		
		head.next.prev=node;
		head.next=node;
		
	}
	//PrintForward
	public void printForward() {
		for(Node curr=head.next; curr != tail; curr=curr.next) {
			System.out.print(curr.data+" ");
		}
		System.out.println();
	}
	//PrintBackward
	public void printBackward() {
		for(Node curr=tail.prev; curr != head; curr=curr.prev) {
			System.out.print(curr.data+" ");
		}
		System.out.println();
	}
	//Remove
	public boolean remove(int data) {
		for(Node curr=head.next; curr != tail; curr=curr.next) {
			if(curr.data == data) {
				curr.prev.next=curr.next;
				curr.next.prev=curr.prev;
				return true;
			}
		}
		return false;
	}
	//helper
	public Node getNodeByIndex(int index) {
		for(Node curr=head.next; curr != tail ; curr=curr.next) {
			if(index-- == 0) {
				return curr.prev;
			}
		}
		return null;
	}
	//REmove At specific index
	public boolean removeAt(int index) {
		Node curr=getNodeByIndex(index);
		if(curr != null) {
			
			curr.next=curr.next.next;
			curr.next.next.prev=curr;
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		SentinelList list = new SentinelList();
//		list.addLast(1);
//		list.addLast(2);
//		list.addLast(3);
//		list.addLast(4);
//		list.printForward();
////		list.printBackward();
//		
//		list.remove(4);
//		list.printForward();
//		list.remove(3);
//		list.printForward();
//		list.remove(2);
//		list.printForward();
//		list.remove(1);
//		list.printForward();
		
		list.addFront(1);
		list.addFront(2);
		list.addFront(3);
//		list.printBackward();
		list.printForward();
		list.removeAt(1);
		list.printForward();
	}
	
}