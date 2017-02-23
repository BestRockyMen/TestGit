package com.example.demo.fragment;

import com.example.demo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FindFragment extends Fragment {
	private String mContent;
	public FindFragment (String content) {
		this.mContent = content;
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 View view = LayoutInflater.from(getActivity()).inflate(R.layout.onefragment,null);
		 TextView tv = (TextView) view.findViewById(R.id.tv);
			tv.setText(mContent);
		return view;
	}
}
