package com.example.jsoup13;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	private ListView lv;
	private MyAdapter adapter;
	private List<News> data;
	private ProgressBar progressBar;
	private FrameLayout layout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.lv);
		showProgressBar();
		
		getData();
		
	}


	private void showProgressBar() {
		progressBar = new ProgressBar(this);
		layout = (FrameLayout) findViewById(R.id.layout);
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.CENTER;
		progressBar.setLayoutParams(params);
		progressBar.setVisibility(View.VISIBLE);
		layout.addView(progressBar);
	}


	private void getData() {
		DataUtil da = new DataUtil();
		da.getNews(new CallBack() {
			
			@Override
			public void onDataLoaded(List<News> data) {
				MainActivity.this.data = data;
				show();
			}
		});
	}


	protected void show() {
		adapter = new MyAdapter(this, data);
		lv.setAdapter(adapter);
		hideProgressBar();
	}


	private void hideProgressBar() {
		if (layout!=null && progressBar!=null) {
			layout.removeView(progressBar);
		}
	}

}
