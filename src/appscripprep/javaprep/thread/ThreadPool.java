package appscripprep.javaprep.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;

	Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("starting: " + id);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed: " + id);

	}
}

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			pool.submit(new Processor(i));
		}
		// Stop accepting new task after completion of all tasks
		pool.shutdown();
		System.out.println("All tasks submitted");

		
		
		// Max wait time for the tasks to complete
		try {
			/*
			 * Blocks until all tasks have completed execution after a shutdown request, or
			 * the timeout occurs, or the current thread is interrupted, whichever happens
			 * first. Parameters:timeout the maximum time to wait unit the time unit of the
			 * timeout argument
			 */
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("All tasks Completed");

	}

}
