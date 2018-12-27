package com.pluralsight.whtasnewonjava8.lambdaandstream.firstLambda;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {
		
		// usando classe anonima para implementar um Runnable
		@SuppressWarnings("unused")
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				
				for (int i = 0; i < 3; i++) {
					System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
				}
				
			}
		};
		
		// usando Lambda
		Runnable runnableLambda = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
			}
		};
		
		Thread t = new Thread(runnableLambda);
		t.start();
		t.join();
		
	}
	
}
