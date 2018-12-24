package edu.csuft.hiccup.spider;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Task implements Runnable {
	
	//任务的编号
	int n;
	
	public Task(int n) {
		super();
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name+" 开始: "+ n);
		//延时,前几天写的代码，就是任务，写到run里面来
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" 结束: "+ n);
		
		
		
	}
	//做一个任务，稍后放到线程池，要搞个接口，也就是
	/*
	 * 定义一个可以交给线程执行的任务
	 */

}
