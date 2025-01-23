package co.sumit.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

	private static class PC {
		private Queue<Integer> Q = new LinkedList<>();
		private final int CAP = 6;

		public void produce() throws InterruptedException {
			synchronized (this) {
				while (true) {
					if (Q.size() == CAP) {
						wait();
					}
					int item = createItem();
					System.out.println("Produced Item:" + item);
					Q.offer(item);
					Thread.sleep(1000);
					notifyAll();
				}
			}

		}

		public void consume() throws InterruptedException {
			synchronized (this) {
				while (true) {
					if (Q.isEmpty()) {
						wait();
					}
					int item = Q.poll();
					processedItem(item);
					Thread.sleep(1000);
					notifyAll();
				}
			}

		}

		private int processedItem(int item) {
			System.out.println("Processed Item:" + item);
			return item;
		}

		private int createItem() {
			int item = new Random().nextInt(100);
			return item;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PC pc = new PC();
		Runnable producer = () -> {

			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable consumer = () -> {

			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

}
