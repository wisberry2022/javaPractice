package com0121;

public class Ex01 {
	static int num = 0;
	
	public static Thread func1(int cnt) {
		Thread thr = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				for(int i = 0; i<cnt; i++) {
					System.out.println(name + "동작 중..." + i);
					num+=10;	
				}
				System.out.println(name + ": " +num);
			}
		});
		return thr;
	}
	
	public static Thread func2(int cnt) {
		Thread thr = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				for(int i = 0; i<cnt; i++) {
					System.out.println(name + "동작 중..." + i);
					num+=10;	
				}
				System.out.println(name + ": " +num);
			}
		});
		return thr;
	}
	
	public static void main(String[] args) {
		System.out.println("main start");
		Thread a = func1(1);
		a.setPriority(1);
		Thread b = func2(1);
		b.setPriority(5);
		
		a.start();
		b.start();
		
		while(a.isAlive() || b.isAlive()) {
			continue;
		}
		
		System.out.println("main end" + num);
		
		
	}

}
