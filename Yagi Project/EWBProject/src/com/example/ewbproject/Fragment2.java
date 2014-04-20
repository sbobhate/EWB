package com.example.ewbproject;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment 
{
	
	TextView text;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment2, container, false);
		text = (TextView) view.findViewById(R.id.quality);
		return view;
	}
	
	public void changeData (int data)
	{
		if (data >= -90)
		{
			text.setText("Good");
			text.setTextColor(Color.parseColor("#669900"));
		}
		else
		{
			text.setText("Bad");
			text.setTextColor(Color.parseColor("#CC0000"));
		}
	}

}
