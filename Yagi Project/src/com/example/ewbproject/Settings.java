package com.example.ewbproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.support.v4.app.NavUtils;

public class Settings extends Activity implements NumberPicker.OnValueChangeListener
{

	static int difference = 1;
	NumberPicker picker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		picker = (NumberPicker) findViewById(R.id.picker);
		picker.setMaxValue(10);
		picker.setMinValue(1);
		picker.setWrapSelectorWheel(false);
		picker.setOnValueChangedListener(this);
		
		picker.setValue(difference);
		
//		Toast.makeText(this, Integer.toString(difference), Toast.LENGTH_SHORT).show();

		setupActionBar();
	}

	@Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) 
	{
		difference = newVal;
    }
	
	@Override
	public void onSaveInstanceState (Bundle outState)
	{
		super.onSaveInstanceState(outState);
		outState.putInt("difference", difference);
	}
	
	@Override
	public void onRestoreInstanceState (Bundle savedInstanceState)
	{
		super.onRestoreInstanceState(savedInstanceState);
		difference = savedInstanceState.getInt("difference");
	}
	
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
