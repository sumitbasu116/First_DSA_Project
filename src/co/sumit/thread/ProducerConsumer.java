package co.sumit.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

	private static class PC{
		private Queue<Integer> Q;
		private int CAP;
		
		public PC(int size) {
			this.CAP=size;
			Q= new LinkedList<>();
		}
		
		public void produce() throws InterruptedException {
			synchronized (this) {
				while(true) {
					if(Q.size()==CAP) {
						wait();
					}
					Q.offer(createItem());
					Thread.sleep(1000);
					notifyAll();
				}
			}
		}
		
		public void consume() throws InterruptedException {
			synchronized (this) {
				while(true) {
					if(Q.isEmpty()) {
						wait();
					}
					int item=Q.poll();
					Thread.sleep(1000);
					processItem(item);
					notifyAll();
				}
			}
		}

		private void processItem(int item) {
			System.out.println("Processing item:"+item);
		}

		private int createItem() {
			int item=new Random().nextInt(90);
			System.out.println("Producing item:"+item);
			return item;
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		PC pc = new PC(6);
		
		Runnable producer = ()->{
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable cosnumer = ()->{
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread prodT=new Thread(producer);
		Thread consT=new Thread(cosnumer);
		
		prodT.start();
		consT.start();
		
		prodT.join();
		consT.join();

	}

}
