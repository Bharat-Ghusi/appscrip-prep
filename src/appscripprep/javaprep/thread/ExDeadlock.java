package appscripprep.javaprep.thread;

public class ExDeadlock {
	public static void doWork(Object lock1,Object lock2) {
		Runnable r1=() -> {
			synchronized (lock1) {
				System.out.println(Thread.currentThread().getName() +" hold lock on [lock1] object.");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println(Thread.currentThread().getName() +" hold lock on [lock2] object.");
				}
			}
			System.out.println(Thread.currentThread().getName() +" release  [lock1 and lock2 object] object.");
			
		};
		
		Runnable r2=() -> {
			synchronized (lock2) {
				System.out.println(Thread.currentThread().getName() +" hold lock on [lock2] object.");
				
				synchronized (lock1) {
					System.out.println(Thread.currentThread().getName() +" hold lock on [lock2] object.");
				}
			}
			System.out.println(Thread.currentThread().getName() +" release  [lock2 and lock1] object.");
			
		};
		
		//Start
		new Thread(r1).start();
		new Thread(r2).start();
	}

	public static void main(String[] args) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		doWork(lock1, lock2);
		
		
	}

}
