package appscripprep.javaprep.thread;

	

public class ExSync {
	private int count=1;
	public synchronized void incrementSalary() {
		System.out.println(Thread.currentThread().getName()+" :: "+count);
		count++;
	}
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					incrementSalary();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					incrementSalary();
				}
			}
		});
		//Start both thread
		t1.start();
		t2.start();
		
		
		//Join: join T1 and T2 thread so that main thread will wait until they finish their work, So that we
		// can print the total count at last
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total Count: "+count);
	}
	
	
	
	
	public static void main(String[] args) {
//		ExSync exSync = new ExSync();
//		exSync.doWork();
		
	}
}
