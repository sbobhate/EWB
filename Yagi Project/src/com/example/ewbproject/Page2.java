package com.example.ewbproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Page2 extends Fragment 
{
	Communicator communicator;
	
	ImageView blueprint;
	
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_page2, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		communicator = (Communicator) getActivity();
		blueprint = (ImageView) getActivity().findViewById(R.id.blueprint);
		blueprint.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				communicator.newActivity();
			}
			
		});
	}
	
	public interface Communicator
	{
		public void newActivity ();
	}
	
}


