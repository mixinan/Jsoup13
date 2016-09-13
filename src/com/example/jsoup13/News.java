package com.example.jsoup13;

public class News {
	private String title;
	private String url;
	private String from;
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(String title, String url, String from) {
		super();
		this.title = title;
		this.url = url;
		this.from = from;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", url=" + url + ", from=" + from + "]";
	}
	
	
}
