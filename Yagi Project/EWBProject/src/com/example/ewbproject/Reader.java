package com.example.ewbproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class Reader extends Activity 
{
	
	SignalStrengthListener signalStrengthListener;
	
	TextView cdmadbm;
	TextView cdmaecio;
	TextView evdodbm;
	TextView evdoecio;
	TextView evdosnr;
	TextView gsmerror;
	TextView gsm;
	
	int CdmaDbm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity_reader);
		   cdmadbm = (TextView)findViewById(R.id.cdmadbm);
		   cdmaecio = (TextView)findViewById(R.id.cdmaecio);
		   evdodbm = (TextView)findViewById(R.id.evdodbm);
		   evdoecio = (TextView)findViewById(R.id.evdoecio);
		   evdosnr = (TextView)findViewById(R.id.evdosnr);
		   gsmerror = (TextView)findViewById(R.id.gsmerror);
		   gsm = (TextView)findViewById(R.id.gsm);
		   
		   signalStrengthListener = new SignalStrengthListener();	           
		   ((TelephonyManager)getSystemService(TELEPHONY_SERVICE)).listen(signalStrengthListener,SignalStrengthListener.LISTEN_SIGNAL_STRENGTHS);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.reader, menu);
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
	
	private class SignalStrengthListener extends PhoneStateListener
	{
	  @Override
	  public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) 
	  {
	    
		  CdmaDbm = signalStrength.getCdmaDbm();
		  int CdmaEcio = signalStrength.getCdmaEcio();
		  int EvdoDbm = signalStrength.getEvdoDbm();
		  int EvdoEcio = signalStrength.getEvdoEcio();
		  int EvdoSnr = signalStrength.getEvdoSnr();
		  int GsmError = signalStrength.getGsmBitErrorRate();
		  int Gsm = signalStrength.getGsmSignalStrength();
	     
		  //do something with it (in this case we update a text view)
		  if (CdmaDbm == -120)
			  cdmadbm.setText("No Network");
	    	else
	    		cdmadbm.setText("CDMA dBm: "+ String.valueOf(CdmaDbm));
		  cdmaecio.setText("CDMA EC/IO: " + String.valueOf(CdmaEcio));
		  if (CdmaDbm == -120)
			  evdodbm.setText("No Network");
		  else
			  evdodbm.setText("Evdo dBm: " + String.valueOf(EvdoDbm));
		  evdoecio.setText("Evdo EC/IO: " + String.valueOf(EvdoEcio));
		  evdosnr.setText("Evdo snr: " + String.valueOf(EvdoSnr));
		  if (GsmError == 99)
			  gsmerror.setText("No Network");
		  else 
			  gsmerror.setText("GSM Bit Error Rate: " + String.valueOf(GsmError));
		  if (Gsm == 99)
			  gsm.setText("No Network");
	   	 else
	   		 gsm.setText("GSM Signal Strength: " + String.valueOf(Gsm));
		  super.onSignalStrengthsChanged(signalStrength);
	  }
	}
	
	public void showCdmaVisual (View v)
	{
		Intent intent = new Intent(this, CdmaVisual.class);
		intent.putExtra("data", CdmaDbm);
		startActivity(intent);
	}

}
