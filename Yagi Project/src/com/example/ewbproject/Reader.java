package com.example.ewbproject;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class Reader extends FragmentActivity 
{
	
	int difference;
	
	SignalStrengthListener signalStrengthListener;
	
	TextView cdmadbm;
	TextView cdmaecio;
	TextView evdodbm;
	TextView evdoecio;
	TextView evdosnr;
	TextView gsmerror;
	TextView gsm;
	
	ImageView quality;
	
	int CdmaDbm;
	
	Settings setting;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_reader);
		
		setting = new Settings();
		difference = Settings.difference;
//		Toast.makeText(this, Integer.toString(difference), Toast.LENGTH_SHORT).show();
		
		cdmadbm = (TextView) findViewById(R.id.cdmadbm);
		cdmaecio = (TextView) findViewById(R.id.cdmaecio);
		evdodbm = (TextView) findViewById(R.id.evdodbm);
		evdoecio = (TextView) findViewById(R.id.evdoecio);
		evdosnr = (TextView) findViewById(R.id.evdosnr);
		gsmerror = (TextView) findViewById(R.id.gsmerror);
		gsm = (TextView) findViewById(R.id.gsm);
		
		quality = (ImageView) findViewById(R.id.quality);
		
		signalStrengthListener = new SignalStrengthListener();	           
		((TelephonyManager)getSystemService(TELEPHONY_SERVICE)).listen(signalStrengthListener,SignalStrengthListener.LISTEN_SIGNAL_STRENGTHS);
	}

	@Override
	public void onResume ()
	{
		super.onResume();
		difference = Settings.difference;
//		Toast.makeText(this, Integer.toString(difference), Toast.LENGTH_SHORT).show();
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
		case R.id.action_settings:
			openSettings();
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
		  {
			  cdmadbm.setText("No Network");
			  quality.setBackgroundResource(R.drawable.nobar);
		  }
		  else
		  {
			  cdmadbm.setText("CDMA dBm: "+ String.valueOf(CdmaDbm));
			  if (CdmaDbm > -120 && CdmaDbm <= -120 + difference)
			  {
				  quality.setBackgroundResource(R.drawable.onebar);
			  }
			  if (CdmaDbm > -120 + difference && CdmaDbm <= -120 + 2*difference)
			  {
				  quality.setBackgroundResource(R.drawable.twobars);
			  }
			  if (CdmaDbm > -120 + 2*difference && CdmaDbm <= -120 + 3*difference)
			  {
				  quality.setBackgroundResource(R.drawable.threebars);
			  }
			  if (CdmaDbm > -120 + 3*difference && CdmaDbm <= -120 + 4*difference)
			  {
				  quality.setBackgroundResource(R.drawable.fourbars);
			  }
			  if (CdmaDbm > -120 + 4*difference && CdmaDbm <= -120 + 5*difference)
			  {
				  quality.setBackgroundResource(R.drawable.fivebars);
			  }
			  if (CdmaDbm > -120 + 5*difference && CdmaDbm <= -120 + 6*difference)
			  {
				  quality.setBackgroundResource(R.drawable.sixbars);
			  }
			  if (CdmaDbm > -120 + 6*difference && CdmaDbm <= -120 + 7*difference)
			  {
				  quality.setBackgroundResource(R.drawable.sevenbars);
			  }
			  if (CdmaDbm > -120 + 7*difference && CdmaDbm <= -120 + 8*difference)
			  {
				  quality.setBackgroundResource(R.drawable.eightbars);
			  }
			  if (CdmaDbm > -120 + 8*difference && CdmaDbm <= -120 + 9*difference)
			  {
				  quality.setBackgroundResource(R.drawable.ninebars);
			  }
			  if (CdmaDbm > -120 + 9*difference && CdmaDbm <= -120 + 10*difference)
			  {
				  quality.setBackgroundResource(R.drawable.ten);
			  }
			  if (CdmaDbm > -120 + 10*difference && CdmaDbm <= -120 + 11*difference)
			  {
				  quality.setBackgroundResource(R.drawable.elevenbars);
			  }
			  if (CdmaDbm > -120 + 11*difference && CdmaDbm <= -120 + 12*difference)
			  {
				  quality.setBackgroundResource(R.drawable.twelvebars);
			  }
			  if (CdmaDbm > -120 + 12*difference)
			  {
				  quality.setBackgroundResource(R.drawable.thirteenbars);
			  }
		  }
		  cdmaecio.setText("CDMA EC/IO: " + String.valueOf(CdmaEcio));
		  if (CdmaDbm == -120)
		  {
			  evdodbm.setText("No Network");
		  }
		  else
		  {
			  evdodbm.setText("Evdo dBm: " + String.valueOf(EvdoDbm));
		  }
		  evdoecio.setText("Evdo EC/IO: " + String.valueOf(EvdoEcio));
		  evdosnr.setText("Evdo snr: " + String.valueOf(EvdoSnr));
		  if (GsmError == 99)
		  {
			  gsmerror.setText("No Network");
		  }
		  else 
		  {
			  gsmerror.setText("GSM Bit Error Rate: " + String.valueOf(GsmError));
		  }
		  if (Gsm == 99)
		  {
			  gsm.setText("No Network");
		  }
	   	 else
	   	 {
	   		 gsm.setText("GSM Signal Strength: " + String.valueOf(Gsm));
	   	 }
		  super.onSignalStrengthsChanged(signalStrength);
	  }
	}
	
	public void openSettings ()
	{
		Intent intent = new Intent(this, Settings.class);
		startActivity(intent);
	}
	
}
