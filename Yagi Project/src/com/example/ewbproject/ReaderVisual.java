package com.example.ewbproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ReaderVisual extends Fragment {
	
	ImageView quality;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.reader_visual, container, false);
		quality = (ImageView) view.findViewById(R.id.quality);
		
		return view;
	}

}
