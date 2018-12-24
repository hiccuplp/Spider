package edu.csuft.hiccup.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderfilmDetail implements Runnable{

	/*
	 * @Hiccup
	 * ӰƬ��url
	 */
	String url;
	/*
	 * ӰƬ�б�
	 */
	List<film> list;
	public SpiderfilmDetail(String url, List<film> list) {
		super();
		this.url = url;
		this.list = list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Document d = Jsoup.connect(url).get();
			Element e = d.getElementById("content");
			
			String name = e.selectFirst("h1 span").text();
			String year = e.select(".year").text();
			
			String director = e.select("#info span").get(0).selectFirst(".attrs a").text();
			String script = e.select("#info .attrs").get(1).text();
			String actor = e.selectFirst(".actor .attrs").text();
            
			System.out.printf("%s, %s, %s, %s\n",
					year,
					name,
					director,
					script
					);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
