package com.demo.c21.threaddemo;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		for (int j = 0; j < 50; j++) {
			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("j=:"+j);
		}
	}

}
