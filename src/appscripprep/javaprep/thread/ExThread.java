package appscripprep.javaprep.thread;

public class ExThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <50; i++) {
			System.out.println("Run: "+i);
		}
	}

	public static void main(String[] args) {
		ExThread t1 = new ExThread();
//		1.Can we call the run method directly from the Main method?
		t1.start();
		t1.start();//Not allowed because it will violet the Thread state.However a thread can be called once.
		for (int i = 10; i <50; i++) {
			System.out.println("Main: "+i);
		}
	}

}
