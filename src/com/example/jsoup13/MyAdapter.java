package com.example.jsoup13;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	private Context context;
	private List<News> data;
	private LayoutInflater inflater;
	
	
	
	public MyAdapter(Context context, List<News> data) {
		super();
		this.context = context;
		this.data = data;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public News getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item, null);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.url = (TextView) convertView.findViewById(R.id.url);
			holder.from = (TextView) convertView.findViewById(R.id.from);
			
			convertView.setTag(holder);
		}
		
		News n = data.get(position);
		holder = (ViewHolder) convertView.getTag();
		holder.title.setText(n.getTitle());
		holder.url.setText(n.getUrl());
		holder.from.setText(n.getFrom());
		
		return convertView;
	}
	
	
	class ViewHolder{
		TextView title, url, from;
	}
	
	
	
}
