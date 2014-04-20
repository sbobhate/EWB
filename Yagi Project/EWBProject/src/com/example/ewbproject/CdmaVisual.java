package com.example.ewbproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class CdmaVisual extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cdma_visual);
		
		Intent intent =  getIntent();
		int data = intent.getIntExtra("data", 0);
		
		FragmentManager manager = getFragmentManager();
		Fragment2 f2 = (Fragment2) manager.findFragmentById(R.id.fragment2);
		if (f2 != null) 
		{
			f2.changeData(data);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.cdma_visual, menu);
		return true;
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

}
