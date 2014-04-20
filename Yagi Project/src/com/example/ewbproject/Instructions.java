package com.example.ewbproject;


import com.example.ewbproject.Page2.Communicator;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;

public class Instructions extends FragmentActivity implements Communicator
{
	
	ViewPager viewPager = null;
	
	Fragment someFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);

		viewPager = (ViewPager) findViewById(R.id.pager);
		FragmentManager fragmentManager = getSupportFragmentManager();
		viewPager.setAdapter(new MyAdapter(fragmentManager));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void newActivity() {
		Intent newActivity = new Intent(this, Blueprint.class);
		startActivity(newActivity);
	}

}

class MyAdapter extends FragmentStatePagerAdapter
{

	public MyAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem (int i)
	{
		Fragment fragment = null;
		if (i == 0)
		{
			fragment = new Page1();
		}
		if (i == 1)
		{
			fragment = new Page2();
		}
		if (i == 2)
		{
			fragment = new Page3();
		}
		if (i == 3)
		{
			fragment = new Page4();
		}
		if (i == 4)
		{
			fragment = new Page5();
		}
		if (i == 5)
		{
			fragment = new Page6();
		}
		if (i == 6)
		{
			fragment = new Page7();
		}
		if (i == 7)
		{
			fragment = new Page8();
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return 8;
	}
	
	@Override
	public CharSequence getPageTitle (int position)
	{
		return null;
	}
	
}
