package appscripprep.javaprep.thread;

class Counter{
	private int count=0;
	public synchronized void increment() {
		System.out.println(count++);
	}
	
	public synchronized void decrement() {
		System.out.println(count--);
	}
	
	public synchronized int getCount() {
		return count;
	}
}
//T
class IncrementThread implements Runnable{
	private Counter counter;
	public IncrementThread(Counter counter) {
		this.counter=counter;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.increment();
		}
	}
}
class DecrementThread implements Runnable{
	private Counter counter;
	 public DecrementThread(Counter counter) {
		 this.counter=counter;
	 }
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.decrement();
		}
	}
}
public class SyncThread {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread t1 = new Thread(new IncrementThread(counter));
		Thread t2 = new Thread(new DecrementThread(counter));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("count: "+counter.getCount());
	}
}
