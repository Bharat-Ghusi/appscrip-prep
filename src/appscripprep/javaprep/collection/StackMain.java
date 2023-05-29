package appscripprep.javaprep.collection;

public class StackMain {

	public static void main(String[] args) {
		Stack1 st = new Stack1();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		while(!st.isEmpty()) {
			System.out.println(st.peak());
			System.out.println(st.pop());
		}
		
	}

}
