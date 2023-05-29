package appscripprep.datastructurevid;

public class DoublyLinkedList {
	private Node head = null;
	private Node tail = null;
	private int size;

	private class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	// Add
	public void add(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	// PrintForward
	public void printForward() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data+ " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// printBackWard
	public void printBackward() {
		Node temp = tail;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}

	// Remove
	public boolean remove(int data) {
		for (Node temp = head; temp != null; temp = temp.next) { 
			if (temp.data == data) {

				// if there is only one node
				if (head == tail) {
					head = tail = null;
				}
				// first node
				else if (temp == head) {
					head = head.next;
					head.prev = null;
				}
				// Last node
				else if (temp == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {

					// Middle node
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}

				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.printForward();
//		list.printBackward();
		list.remove(1);
		list.printForward();
		list.remove(4);
		list.printForward();
		list.remove(3);
		list.printForward();
		list.remove(2);
		list.printForward();

	}

}
