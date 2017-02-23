package com.example.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import com.example.demo.fragment.ChatFragment;
import com.example.demo.fragment.FindFragment;
import com.example.demo.fragment.MyFragment;
import com.example.demo.fragment.TongXunLuFragment;
import com.example.widget.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	private SearchView seach;
	private Fragment chatFragment;
	private Fragment findFragment;
	private Fragment tongFragment;
	private Fragment myFragment;
	private PagerSlidingTabStrip tabs;
	private DrawerLayout dl;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setOverflowShowingAlways();
		dm = getResources().getDisplayMetrics();
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tab);
		dl = (DrawerLayout) findViewById(R.id.dl);



//		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//		navigationView.setNavigationItemSelectedListener(this);


		ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
		viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		tabs.setViewPager(viewpager);
		//代码控制ActionBar的显示与隐藏
//		ActionBar bar =  getActionBar();
////		bar.hide();
//		bar.show();
		
//		bar.setSubtitle("hshhs");
//		bar.setTitle("你好");
//		bar.setDisplayHomeAsUpEnabled(true); //ActionBar左侧的箭头
		setTabsValue();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.main, menu);
//		getMenuInflater().inflate(R.menu.main, menu);
//
//		MenuItem item = menu.findItem(R.id.action_serche);
//		seach =  (SearchView) item.getActionView();
//		seach.setSubmitButtonEnabled(true);//右边显示小箭头
 
	        // 设置search view的背景色
//		seach.setBackgroundColor(0x22ff00ff);
//		seach.setOnQueryTextListener(new OnQueryTextListener() {
			/**
			 * 输入完成后，点击小箭头或者软键盘的回车时触发的方法，一般情况是点击输入法中的搜索按钮才会触发。表示现在正式提交了
			 */
//			@Override
//			public boolean onQueryTextSubmit(String arg0) {
//				Toast.makeText(MainActivity.this, arg0, Toast.LENGTH_SHORT).show();
//				return true;
//			}
			
			/**
			 * 在输入时触发的方法，当字符真正显示到searchView中才触发，像是拼音，在舒服法组词的时候不会触发
			 */
//			@Override
//			public boolean onQueryTextChange(String arg0) {
//				if(seach != null){
//					 // 得到输入管理对象
//					InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//					if(manager != null){
//						 // 这将让键盘在所有的情况下都被隐藏，但是一般我们在点击搜索按钮后，输入法都会乖乖的自动隐藏的。
//						manager.hideSoftInputFromWindow(seach.getWindowToken(), 0);// 输入法如果是显示状态，那么就隐藏输入法
//					}
//					seach.clearFocus(); // 不获取焦点
//				}
//				return true;
//			}
//		});
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
	switch (id) {
	case R.id.action_serche:
		Toast.makeText(MainActivity.this, "搜索" ,Toast.LENGTH_SHORT).show();
		break;
	case R.id.action_add:
		Toast.makeText(MainActivity.this, "添加" ,Toast.LENGTH_SHORT).show();
		break;
	case android.R.id.home:
	MainActivity.this.finish();
		break;

	default:
		break;
		
	}
	return true;
		
		
		
		
	 
	}
	
	/**
	 * 解决overflow菜单列表中的图片不显示问题
	 */
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		if(featureId == Window.FEATURE_ACTION_BAR && menu != null){
			if(menu.getClass().getSimpleName().equals("MenuBuilder")){
				try {
					Method m = menu.getClass().getDeclaredMethod(
							"setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e) {
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}
	
	
	/**解决ActionBar最右边的overflow按钮不见了的原因:
		在onCreate()方法的最后调用了该方法，
		就是使用反射的方式将sHasPermanentMenuKey的值设置成false
		显示overflow按钮
	 **/
	private void setOverflowShowingAlways() {  
	    try {  
	        ViewConfiguration config = ViewConfiguration.get(this);  
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");  
	        menuKeyField.setAccessible(true);  
	        menuKeyField.setBoolean(config, false);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}

	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		return false;
	}


	class MyPagerAdapter extends FragmentPagerAdapter{
		private String[] titles = {"聊天","发现","通讯录","我"};
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			 
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return titles.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			
			return titles[position];
		}
		
		@Override
		public Fragment getItem(int arg0) {
			
			switch (arg0) {
			case 0:
				if(chatFragment == null){
					chatFragment = new ChatFragment("这是聊天界面");
				}
				return chatFragment;
			case 1:
				if(findFragment == null){
					findFragment = new FindFragment("这是发现界面");
				}
				return findFragment;
			case 2:
				if(tongFragment == null){
					tongFragment = new TongXunLuFragment("这是通讯录界面");
				}
				return tongFragment;
			case 3:
				if(myFragment == null){
					myFragment = new MyFragment("这是我的界面");
				}
				return myFragment;

			default:
				return null;
			}
			
			
			
			
			
		}

	
		
	}
	
	/**
	 * 对PagerSlidingTabStrip的各项属性进行赋值。
	 */
	/**
	 * 获取当前屏幕的密度
	 */
	private DisplayMetrics dm;
	private void setTabsValue() {
		// 设置Tab是自动填充满屏幕的
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab标题文字的大小
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 14, dm));
		// 设置Tab Indicator的颜色
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		tabs.setTabBackground(0);
	}
	
}
