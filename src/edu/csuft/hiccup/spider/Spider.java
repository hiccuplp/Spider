package edu.csuft.hiccup.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * ץȡҳ����ӰƬ����Ϣ�����棨����
 */
public class Spider implements Runnable{

	/*
	 * ҳ��·����(URL)
	 */
	String url = "";
	/*
	 * �洢ץȡ������
	 */
	ArrayList<film> list;
	
	/*
	 * ��������
	 * @param url         ҳ���·��
	 * @param list        �洢���ݵ��б�
	 */
	
	public Spider(String url, ArrayList<film> list) {
		super();
		this.url = url;
		this.list = list;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		//���ִ�и�������̵߳�����
		String name = Thread.currentThread().getName();
		System.out.println(name +"�߳� ������"+ url);
		
		//JSOUP
		try {
			Document d = Jsoup.connect(url).get();
			
			//���ĵ�����������һ�������в��ҽڵ�
			Elements es = d.select(".grid_view .item");
			//����
			for(Element e :es){   
		    	film f = new film();
 //ÿһ��ӰƬ
//		    	Element t = e.select(".title").first();
//		    	String num=e.select(".star span").last().text();
//		    	System.out.println(t.text()+","+ num.substring(0,num.length()-3));
		    	
		    	f.id = Integer.parseInt(e.select(".pic em").first().text());
		    	f.poster = e.select("img").first().attr("src");
		    	f.info = e.select(".bd p").first().text();
		    	f.title = e.select(".title").first().text();
		    	f.rating = Double.parseDouble(e.select(".rating_num").first().text());
		    	String num = e.select(".star span").last().text();
		    	f.num = Integer.parseInt(num.substring(0, num.length()-3));
		    	f.quote=e.select(".inq").first().text();
		    	f.url = e.select(".pic a").first().attr("herf");
		    	
//		    	System.out.println(f);
				list.add(f);
		    }
			System.out.println(name+" �̣߳���ɣ�"+ url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
