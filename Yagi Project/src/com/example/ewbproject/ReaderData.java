package com.example.ewbproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReaderData extends Fragment {

	TextView cdmadbm;
	TextView cdmaecio;
	TextView evdodbm;
	TextView evdoecio;
	TextView evdosnr;
	TextView gsmerror;
	TextView gsm;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.reader_data, container, false);
				
		cdmadbm = (TextView) view.findViewById(R.id.cdmadbm);
		cdmaecio = (TextView) view.findViewById(R.id.cdmaecio);
		evdodbm = (TextView) view.findViewById(R.id.evdodbm);
		evdoecio = (TextView) view.findViewById(R.id.evdoecio);
		evdosnr = (TextView) view.findViewById(R.id.evdosnr);
		gsmerror = (TextView) view.findViewById(R.id.gsmerror);
		gsm = (TextView) view.findViewById(R.id.gsm);
		
		return view;
	}

}
