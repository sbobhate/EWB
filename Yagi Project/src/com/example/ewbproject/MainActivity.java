package com.example.ewbproject;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
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
		case R.id.about_us:
			goToAboutUs(null);
		}
		return super.onOptionsItemSelected(item);
	}

	public void goToAboutUs (View view)
	{
		Intent newActivity = new Intent(this, AboutUs.class);
		startActivity(newActivity);
	}
	
	public void goToInstructions (View view)
	{
		Intent newActivity = new Intent(this, Instructions.class);
		startActivity(newActivity);
	}
	
	public void goToReader (View view)
	{
		Intent newActivity = new Intent(this, Reader.class);
		startActivity(newActivity);
	}
	
	public void visitSite (View view)
	{
		Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://globalappinitiative.org"));
		startActivity(browserIntent);
	}
	
}
