package appscripprep.javaprep.thread;
class Company{
	private int item;
	private boolean check=true;;

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
	//True : for producer
	//false : for consumer
	synchronized public void produced(int item) {
		if(!check) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.item=item;
		System.out.println("Produced: "+this.item);
		check=false;//Time for consumer.
		notify();
		
	}
	synchronized public void consumed() {
		if(check) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumed: "+this.item);
		check=true;
		notify();
		
	}
	
}



//Main Method
public class ExSync1 {
	public static void getStatus(Company com) {
		Thread producerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					com.produced(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
		Thread consumerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					com.consumed();;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		//Start thread
		producerThread.start();
		consumerThread.start();
	}
	public static void main(String[] args) {
		/*
		 * Synchronized: Let's only one thread inside the function at a time
		 * Avoids: Race condition
		 */
		getStatus(new Company());
	}
	
}
