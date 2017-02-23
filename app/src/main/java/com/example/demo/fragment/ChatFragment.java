package com.example.demo.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bean.UserBean;
import com.example.demo.DetailsActivity;
import com.example.demo.ListCallBack;
import com.example.demo.R;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class ChatFragment extends Fragment {
	private String mContent;
	private ListView listview;
	private MyAdapter adapter;

	public ChatFragment(String content) {
		this.mContent = content;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.chatfragment, null);
		listview = (ListView) view.findViewById(R.id.lv);

		if (adapter == null) {
			adapter = new MyAdapter();
			listview.setAdapter(adapter);
			testData();

			listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
					startActivity(new Intent(getActivity(), DetailsActivity.class));
				}
			});
		}
		return view;
	}

	private String url = "http://203.171.235.72:8058/list_chuangke.aspx";

	private void testData() {
		UserBean bean = new UserBean();
		bean.setName("齐天大圣孙悟空");
		bean.setTime("2012-12-12");
		bean.setContent("500年前孙猴子大闹天宫,你知道吗？!");
		list.add(bean);
	
		OkHttpUtils.get()//设置GET方式访问网络
		.url(url)//网络接口地址
		.addParams("type", "0")//参数
		.build()
		.execute(new ListCallBack() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onResponse(List<UserBean> list, int arg1) {
				 
				Toast.makeText(getActivity(), list.toString(), Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onError(Call arg0, Exception arg1, int arg2) {
			
				Toast.makeText(getActivity(), "网络解析错误！", Toast.LENGTH_SHORT).show();
			}
		});

	}

	private List<UserBean> list = new ArrayList<UserBean>();
	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View convertView, ViewGroup parement) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = View.inflate(parement.getContext(),
						R.layout.item_chat, null);
				holder = new ViewHolder(convertView);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.tv_content.setText(list.get(arg0).getContent().toString());
			holder.tv_name.setText(list.get(arg0).getName().toString());
			holder.tv_time.setText(list.get(arg0).getTime().toString());

			return convertView;
		}

		class ViewHolder {
			ImageView iv_header, iv_img;
			TextView tv_name, tv_content, tv_time;

			public ViewHolder(View v) {
				iv_header = (ImageView) v.findViewById(R.id.iv_header);
				iv_img = (ImageView) v.findViewById(R.id.iv_img);
				tv_name = (TextView) v.findViewById(R.id.tv_name);
				tv_content = (TextView) v.findViewById(R.id.tv_content);
				tv_time = (TextView) v.findViewById(R.id.tv_time);
				v.setTag(this);
			}
		}

	}



}
