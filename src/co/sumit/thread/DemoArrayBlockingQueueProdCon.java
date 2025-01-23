package co.sumit.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DemoArrayBlockingQueueProdCon {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(5);
		Runnable producer = ()->{
			try {
				while(true) {
					queue.put(createItem());//Thread safe method for Q to offer item.
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		new Thread(producer).start();
		new Thread(producer).start();
		Runnable consumer = ()->{
			while(true) {
				Integer item;
				try {
					//Thread safe method for Q to offer item.
					item = queue.take();
					Thread.sleep(1000);
					processItem(item);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(consumer).start();
		new Thread(consumer).start();
		
		
	}
	
	private static Integer createItem() {
		int nextInt = new Random().nextInt(11);
		System.out.println("item produced:"+nextInt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nextInt;
	}
	
	private  static void processItem(Integer item) {
		System.out.println("item processed:"+item);
	}

}
