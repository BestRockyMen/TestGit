package com.example.demo;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class PlusActionProvider extends ActionProvider {
	private Context context;

	public PlusActionProvider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;

	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		// TODO Auto-generated method stub
		subMenu.clear();
		subMenu.add(context.getString(R.string.plus_group_chat))
				.setIcon(R.drawable.ofm_group_chat_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(context, "发起群聊", 0).show();
						return true;
					}
				});

		subMenu.add(context.getString(R.string.plus_add_friend))
				.setIcon(R.drawable.ofm_add_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(context, "添加朋友", 0).show();
						return true;
					}
				});
		subMenu.add(context.getString(R.string.plus_video_chat))
				.setIcon(R.drawable.ofm_video_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(context,R.string.plus_video_chat, 0).show();
						return false;
					}
				});
		subMenu.add(context.getString(R.string.plus_scan))
				.setIcon(R.drawable.ofm_qrcode_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(context,R.string.plus_scan, 0).show();
						return false;
					}
				});
		subMenu.add(context.getString(R.string.plus_take_photo))
				.setIcon(R.drawable.ofm_camera_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(context,R.string.plus_take_photo, 0).show();
						return false;
					}
				});
	}

	@Override
	public boolean hasSubMenu() {
		// TODO Auto-generated method stub
		return true;
	}
}
