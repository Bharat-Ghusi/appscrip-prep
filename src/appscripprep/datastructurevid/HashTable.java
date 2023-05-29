package appscripprep.datastructurevid;

public class HashTable {
	private int size;
	private Node[] table;

	public HashTable() {
		this.size=10;
		this.table=new Node[size];
	}

	private class Node {
		private int key;
		private String data;
		private Node next;

		public Node(int key, String data) {
			super();
			this.key = key;
			this.data = data;
		}

	}

//Hash function
	public int hash(int key) {
		return key % table.length;
	}
	
	//put method
	public void put(int key,String data) {
		int offset = hash(key);
		Node node = new Node(key, data);
		node.next=table[offset]; //Current head node becomes next of new NOde[ head: table[offset] ]
		table[offset]=node; //update head;
	}
	//printAll
	public void print() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			str.append(i+" [ ");
			Node node=table[i];
			while(node != null) {
				str.append("{ "+node.key+", "+node.data+" } ");
				node=node.next;
			}
			str.append(" ]\n");
		}
		System.out.println(str.toString());
	}
	//remove
	public boolean remove(int key) {
		int offset = hash(key);
		Node prev=null;
		for(Node curr=table[offset]; curr != null ;curr=curr.next) {
			
			if(curr.key == key) {
				//case-1 key may be the head
				if(table[offset] == curr) {
					table[offset]=curr.next;
				}
				//case -2 Last element
				else if(curr.next == null) {
					prev.next=null;
				}
				//Case-3 middle
				else {
					prev.next=curr.next;
				}
				return true;
			}
			//BAck of curr
			 prev=curr;
			
		}
		return false;
	}
	
	//MAIN MEHTOD
	public static void main(String[] args) {
		HashTable hash = new HashTable();
		hash.put(423, "A");
		hash.put(424, "B");
		hash.put(425, "C");
		hash.put(353, "D");
		hash.put(373, "E");
		hash.print();
		hash.remove(353);
		hash.print();
	}
}
