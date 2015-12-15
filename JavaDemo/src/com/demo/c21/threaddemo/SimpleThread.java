package com.demo.c21.threaddemo;

public class SimpleThread extends Thread {
	private int countdown=5;
	private static int count=0;
	
	public SimpleThread() {
		super("MyThread:"+Integer.toString(++count));
		start();
	}

	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(--countdown==0)return;
		}
	}
	@Override
	public String toString() {
		return "Name:"+this.getName()+"\t[countDown]:"+countdown;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SimpleThread();
		}
	}
}
