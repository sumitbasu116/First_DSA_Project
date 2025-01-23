package co.sumit.thread;

public class EvenOdd {

	public static void main(String[] args) throws InterruptedException {
		Integer num=10; 
		Runnable odd=()->{
			synchronized (num) {
				for(int i=1;i<=num;i++) {
					if(i%2!=0) {
						System.out.println("i:"+i);
					}
				}
			}
		};
		
		Runnable even=()->{
			synchronized (num) {
				for(int i=1;i<=num;i++) {
					if(i%2==0) {
						System.out.println("i:"+i);
					}
				}
			}
		};
		
		Thread t1=new Thread(even);
		t1.start();
		Thread t2=new Thread(odd);
		
		t2.start();
		
		t1.join();
		t2.join();

	}

}
