package appscripprep.javaprep.thread;

class MyThread1 implements Runnable {
	private int num;

	public MyThread1(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" printing: "+num++);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}

public class MainThread {

	public static void main(String[] args) {
		new Thread(new MyThread1(10)).start();;
		new Thread(new MyThread1(30)).start();;
	}

}
