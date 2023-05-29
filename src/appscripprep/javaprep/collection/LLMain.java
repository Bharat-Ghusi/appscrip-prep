package appscripprep.javaprep.collection;

public class LLMain {

	public static void main(String[] args) {
		//MAIN method
			LL list = new LL();
//			list.addFirst(2);
//			list.addFirst(3);
//			list.addFirst(4);
//			list.addFirst(5);
			
			list.addLast(2);
			list.addLast(3);
			list.addLast(4);
			list.addLast(5);
			
			list.display();
			System.out.println("Head: "+list.getHead());
			System.out.println("Tail: "+list.getTail());
			list.addAt(1, 1);
			list.display();
	}

}
