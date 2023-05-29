package appscripprep.javaprep.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class N05_Queue {

	public static void main(String[] args) {
		solve1();
	}
	//PriorityQueue
	public static void solve1() {
		PriorityQueue<Student> queue = new PriorityQueue<>(new StudentNameComparator());
		queue.add(new Student(2, "Avilash"));
		queue.add(new Student(6, "Bharat"));
		queue.add(new Student(1, "Avi"));
		queue.add(new Student(4, "Kunal"));
		queue.add(new Student(7, "Cool"));
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		

	}
	public static void solve2() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.offer(1);
		deque.addFirst(7);
		deque.offerFirst(2);
		System.out.println(deque);
	}

}
