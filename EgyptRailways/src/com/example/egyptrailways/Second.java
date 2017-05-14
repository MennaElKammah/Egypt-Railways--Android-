package com.example.egyptrailways;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.Spinner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Second extends ActionBarActivity implements OnClickListener {
	Spinner times;
	Spinner prices;
	Spinner dist;
	Spinner src;
	Button logout;
	Button submit ;

	String fullName ;
	String nameStr ;

	Boolean timeFlag = false ;
	Boolean pricesFlag = false ;
	Boolean distFlag = false ;
	Boolean submitFlag = false ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		this.fullName = getIntent().getExtras().getString("fullName");
		this.nameStr = getIntent().getExtras().getString("nameStr");
		TextView trainTimes = (TextView) findViewById(R.id.trainTimes);
		submit = (Button) findViewById(R.id.Submit);
		logout = (Button) findViewById(R.id.logOut);
		times = (Spinner) findViewById(R.id.times);
		prices = (Spinner) findViewById(R.id.prices);
		dist = (Spinner) findViewById(R.id.distCities);
		src = (Spinner) findViewById(R.id.srcCities);
		submit.setOnClickListener(this);
		logout.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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


	public void onBackPressed() {

		return;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if(v.getId() == R.id.logOut){
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);	
		}
		
		else if (dist.getSelectedItem().toString().equals(src.getSelectedItem().toString())
				&& !dist.getSelectedItem().toString().equals("Select a city..."))
			Toast.makeText(Second.this,
					"Not Allowed , Source and Destination cities are the same. !", Toast.LENGTH_SHORT)
					.show();
		else if (times.getSelectedItem().toString().equals("Select time...")
				|| prices.getSelectedItem().toString().equals("Select a class...")
				|| dist.getSelectedItem().toString().equals("Select a city...")
				|| src.getSelectedItem().toString().equals("Select a city..."))
			Toast.makeText(Second.this,
					"Please fill all of the above fields!", Toast.LENGTH_SHORT)
					.show();
		else if(v.getId() == R.id.Submit){
			Toast.makeText(Second.this,
					"Your registeration was made Successfully!", Toast.LENGTH_SHORT)
					.show();

			//			AssetsData readData = new AssetsData();
			//			readData.getData();
			//			this.time = readData.time;
			//			this.price = readData.price;
			//			this.dist = readData.dist;
			//			this.src = readData.src;


			//			times.getSelectedItem().toString()
			//			prices.getSelectedItem().toString()
			//			dist.getSelectedItem().toString()
			//			src.getSelectedItem().toString()


			//			File f = new File("data.txt");
			//			try {
			//				FileWriter fw = new FileWriter(f);
			//				fw.write(times.getSelectedItem().toString());
			//				fw.write("\n");
			//				fw.write(prices.getSelectedItem().toString());
			//				fw.write("\n");
			//				fw.write(dist.getSelectedItem().toString());
			//				fw.write("\n");
			//				fw.write(src.getSelectedItem().toString());
			//				fw.close();
			//			} catch (IOException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}



			Intent intent = new Intent(this, Tickets.class);

			intent.putExtra("time", times.getSelectedItem().toString());
			intent.putExtra("price", prices.getSelectedItem().toString());
			intent.putExtra("dist", dist.getSelectedItem().toString());
			intent.putExtra("src", src.getSelectedItem().toString());
			intent.putExtra("fullName", fullName);
			intent.putExtra("nameStr", nameStr);
			startActivity(intent);	
		}
	}
}

