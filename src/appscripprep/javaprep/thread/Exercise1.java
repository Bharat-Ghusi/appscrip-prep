package appscripprep.javaprep.thread;

import java.util.Scanner;
/*
 * Set shared variable to volatile to avoid caching between threads
 *  and guarantees that any thread will read the most recent written values
 */
public class Exercise1  extends Thread{
	private boolean running=true;
	@Override
	public void run() {
		while(running) {
			System.out.println("Awake");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void shutdown() {
		this.running=false;
	}
	public static void main(String[] args) {
		Exercise1 t1 = new Exercise1();
		t1.start();
		System.out.println("Press Enter to stop.");
		new Scanner(System.in).nextLine();
		t1.shutdown();
		
	}

}
