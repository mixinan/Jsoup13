package com.example.jsoup13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;

public class DataUtil {
	public void getNews(final CallBack callback){
		
		
		AsyncTask<String, String, List<News>> task = new AsyncTask<String, String, List<News>>(){

			@Override
			protected List<News> doInBackground(String... params) {
				List<News> data = new ArrayList<News>();
				try {
					Document doc = Jsoup.connect(HttpUtil.getNewsUrl(2)).get();
//					System.out.println(doc);
					
					Element e = doc.getElementsByClass("p2").first();
					Elements es = e.children();
//					System.out.println(es);
					
					for (int i = 0; i < es.size(); i++) {
						
						
						Element alone = es.get(i);
						
						//获取“来源”
						String from = alone.getElementsByClass("c").first().text();
						
						//获取链接和题目
						Element content = alone.getElementsByTag("a").first();
						String title = content.text();
						String url = content.attr("href");
//						System.out.println(from+"\n"+title+"\n"+url+"\n");
						
						News n = new News(title, url, from);
						
						data.add(n);
					}
					
					return data;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return null;
			}
			
			
			@Override
			protected void onPostExecute(List<News> result) {
				super.onPostExecute(result);
				
				callback.onDataLoaded(result);
			}
			
		};
		
		
		
		
		task.execute();
		
	}
}
