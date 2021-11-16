package com.hangga.helitoon;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private Hero ahero;
	private Button btnUp, btnDown;
	
	private androidx.appcompat.app.ActionBar mActionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mActionBar = getSupportActionBar();
		mActionBar.setTitle("PAIJO");
		mActionBar.setSubtitle("Pancen Bocah Bejo");
		mActionBar.setDisplayHomeAsUpEnabled(true);
		
		ahero = (Hero) findViewById(R.id.ahero);
		btnUp = (Button) findViewById(R.id.btnUp);
		btnDown = (Button) findViewById(R.id.btnDown);
		btnUp.setOnTouchListener(btnPosTounch);
		btnDown.setOnTouchListener(btnPosTounch);
	}
	
	OnTouchListener btnPosTounch = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (v == btnUp){
					UpdatePos("up");
				} else if (v == btnDown){
					UpdatePos("down");
				}
				break;

			}
			return true;
		}
	};
	
	private void UpdatePos(String param){
		LayoutParams layoutParams = (LayoutParams) ahero.getLayoutParams();
		if (param.equalsIgnoreCase("up")){
			layoutParams.topMargin = layoutParams.topMargin - 10; 
		} else if (param.equalsIgnoreCase("down")){
			layoutParams.topMargin = layoutParams.topMargin + 10;
		}
		ahero.setLayoutParams(layoutParams);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

/*	*//**
	 * A placeholder fragment containing a simple view.
	 *//*
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}*/

}
