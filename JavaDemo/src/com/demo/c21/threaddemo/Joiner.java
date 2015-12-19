package com.demo.c21.threaddemo;

public class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(Sleeper sleeper) {
		super();
		this.sleeper = sleeper;
	}

	@Override
	public void run() {
		try {
			sleeper.join();
			System.out.println(Thread.currentThread().getName() + "comepleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Sleeper sleeper=new Sleeper();
		Joiner joiner=new Joiner(sleeper);
//		sleeper.start();
		joiner.start();
	}

}
