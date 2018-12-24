package edu.csuft.hiccup.spider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * @author Hiccup
 * 
 */


public class App {
	/*
	 *      @author  Hiccup
	 * 
	 */
	// alt* /
	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(8);
		
		
//		pool = Executors.newCachedThreadPool();
		
//		pool = Executors.newSingleThreadExecutor();
		
		ArrayList<film> list = new ArrayList<film>();
		String url = "https://movie.douban.com/top250?start=";
		for (int i = 0; i <= 100 ; i++) {
			
			String path = String.format("%s%d",url, i*25);
			pool.submit(new Spider(url+(25*i),list));
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());
		while(!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e){
				e.printStackTrace();
			}		
		}
		//数据排序
		Collections.sort(list);
		System.out.println(list.size());
		
		ExecutorService pool2 = Executors.newFixedThreadPool(4);
		
		for(film film : list ) {
			System.out.println(film.url);
			pool2.execute(new SpiderfilmDetail(film.url, list));
			pool2.shutdown();
		//写入文件;绝对路径,相对路径
//		String file = "C:\\film.csv";
//	    file = "film.csv";
		
		//to
//		try(FileWriter out = new FileWriter(film)) {
//			//写数据
//			for (film film1 : list) {
//				out.write(film1.toCSV());
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		}
		}
}









