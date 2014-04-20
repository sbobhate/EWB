package com.example.ewbproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Instructions extends Activity 
{
	
	FragmentManager manager;
	
	float x1,x2;
    float y1, y2;
    int counter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);

		counter = 0;
		manager = getFragmentManager();
		
		displayCorrectFragment(counter);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.instructions, menu);
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
	
	public boolean onTouchEvent(MotionEvent touchevent) 
    {
		 switch (touchevent.getAction())
        {	
        	// when user first touches the screen we get x and y coordinate
         	case MotionEvent.ACTION_DOWN: 
         	{
         		x1 = touchevent.getX();
         		y1 = touchevent.getY();
	           	break;
         	}
         	case MotionEvent.ACTION_UP: 
         	{
         		x2 = touchevent.getX();
         		y2 = touchevent.getY(); 

         		//if left to right sweep event on screen
           		if (x1 < x2 && (x2 - x1) >= 150) 
           		{
           			// Toast.makeText(this, "Left to Right Swap Performed", Toast.LENGTH_LONG).show();
           			decrease();
           		}
                            
           		// if right to left sweep event on screen
           		if (x1 > x2 && (x1 - x2) >= 150)
           		{
           			// Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
            	   	increase();
           		}  
           		break;
         	}
        }
        return false;
    }
	
	public void increase () 
	{
		if (counter < 7)
		{
			counter += 1;
			displayCorrectFragment(counter);
		}
		else
		{
			Toast.makeText(this, "Last Page Reached", Toast.LENGTH_LONG).show();
		}
	}
	
	public void decrease () 
	{
		if (counter > 0)
		{
			counter -= 1;
			displayCorrectFragment(counter);
		}
		else
		{
			Toast.makeText(this, "First Page Reached", Toast.LENGTH_LONG).show();
		}
	}
	
	public void displayCorrectFragment(int counter) {
		if (counter == 0)
		{
			Page1 fragment = new Page1();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 1", Toast.LENGTH_LONG).show();
		}
		if (counter == 1)
		{
			Page2 fragment = new Page2();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 2", Toast.LENGTH_LONG).show();
		}
		if (counter == 2)
		{
			Page3 fragment = new Page3();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 3", Toast.LENGTH_LONG).show();
		}
		if (counter == 3)
		{
			Page4 fragment = new Page4();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 4", Toast.LENGTH_LONG).show();
		}
		if (counter == 4)
		{
			Page5 fragment = new Page5();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 5", Toast.LENGTH_LONG).show();
		}
		if (counter == 5)
		{
			Page6 fragment = new Page6();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 6", Toast.LENGTH_LONG).show();
		}
		if (counter == 6)
		{
			Page7 fragment = new Page7();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 7", Toast.LENGTH_LONG).show();
		}
		if (counter == 7)
		{
			Page8 fragment = new Page8();
			manager.beginTransaction().replace(R.id.main_layout, fragment).commit();
			Toast.makeText(this, "Page 8", Toast.LENGTH_LONG).show();
		}
		else
		{
			//Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
		}
	}

}
