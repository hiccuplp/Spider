package edu.csuft.hiccup.spider;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Task implements Runnable {
	
	//����ı��
	int n;
	
	public Task(int n) {
		super();
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name+" ��ʼ: "+ n);
		//��ʱ,ǰ����д�Ĵ��룬��������д��run������
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" ����: "+ n);
		
		
		
	}
	//��һ�������Ժ�ŵ��̳߳أ�Ҫ����ӿڣ�Ҳ����
	/*
	 * ����һ�����Խ����߳�ִ�е�����
	 */

}
