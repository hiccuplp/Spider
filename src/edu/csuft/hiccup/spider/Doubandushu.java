package edu.csuft.hiccup.spider;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Doubandushu {

	public static void main(String[] args) {
		
		
		try {
		    String url = "https://read.douban.com/category/?kind=105";
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.select(".works-list .works-item");
			//id前要加#  class前加.

		    
		    //创建一个存储书的列表
		    ArrayList<books> list = new ArrayList<>();
		    
		    for(Element e :es){   
		    	books b = new books();
		    	b.title = e.select(".title").first().text();
		    	b.author = e.select(".author").first().text();
		    	
		    	System.out.println(b);
		    	list.add(b);
		    }
		System.out.println(es.size());
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
