package com.demo.c21.threaddemo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{
	private IntGenerator intGenerator;
	private final int id;
	
	public EvenChecker(IntGenerator intGenerator, int id) {
		super();
		this.intGenerator = intGenerator;
		this.id = id;
	}

	@Override
	public void run() {
		while(!intGenerator.isCanceled()){
			int val=intGenerator.next();
			if(val%2!=0){
				System.out.println(val+"not even");
				intGenerator.cancel();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		IntGenerator intGenerator=new EvenGenerator();
		for (int i = 0; i < 100; i++) {
			exec.execute(new EvenChecker(intGenerator, i));
		}
		exec.shutdown();
	}
}
