
package edu.csuft.hiccup.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App_2 {
	/*
	 *      @author  Hiccup
	 * 
	 */
	// alt* /
	public static void main(String[] args) {
			//  Ŀ�� URL
		String url="https://movie.douban.com/top250";	
		//ʹ��  jsoup ץȡ�ĵ�
		try {
			Document doc =  Jsoup.connect(url).get();
			//�����get������ʲô��˼��
			
		    Elements es = doc.select(".grid_view .item");
		    System.out.println(es.size());
		    
		    //CH����һ���洢ӰƬ���б�
		    ArrayList<film> list=new ArrayList<>();
		    
		    for(Element e :es){   
		    	film f = new film();
// ÿһ��ӰƬ
		    	
		    	f.id = Integer.parseInt(e.select(".pic em").first().text());
		    	f.poster = e.select("img").first().attr("src");
		    	f.info = e.select(".bd p").first().text();
		    	f.title = e.select(".title").first().text();
		    	f.rating = Double.parseDouble(e.select(".rating_num").first().text());
		    	String num = e.select(".star span").last().text();
		    	f.num = Integer.parseInt(num.substring(0, num.length()-3));
		    	f.quote=e.select(".inq").first().text();
		    	//style�Ѿ������������styleȡ�ɲ����������
		    	f.othername = e.select(".playable").text();
		    	System.out.println(f);
				list.add(f);
		    }
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
