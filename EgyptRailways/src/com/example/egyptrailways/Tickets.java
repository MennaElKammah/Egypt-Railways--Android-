package com.example.egyptrailways;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tickets extends ActionBarActivity implements OnClickListener {
	public String time, price, dist, src , fullName , accountName ;
	TextView timeText ;
	TextView priceText ;
	TextView destinationText ;
	TextView sourceText ;
	TextView fullNameText ;
	TextView accountNameText ;
	Button reSubmit2 ;
	Button logOut2 ;
	Button returnTicket ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.time = getIntent().getExtras().getString("time");
		this.price = getIntent().getExtras().getString("price");
		this.dist = getIntent().getExtras().getString("dist");
		this.src = getIntent().getExtras().getString("src");
		this.fullName = getIntent().getExtras().getString("fullName");
		this.accountName = getIntent().getExtras().getString("nameStr");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tickets);
		
		timeText = (TextView)findViewById(R.id.time);
		priceText = (TextView)findViewById(R.id.price);
		destinationText = (TextView)findViewById(R.id.destination);
		sourceText = (TextView)findViewById(R.id.source);
		fullNameText = (TextView)findViewById(R.id.fullName);
		accountNameText = (TextView)findViewById(R.id.accountName);
		
		reSubmit2 = (Button) findViewById(R.id.Submit2);
		logOut2 = (Button) findViewById(R.id.logOut2);
		returnTicket = (Button) findViewById(R.id.returnTicket);
		
		reSubmit2.setOnClickListener(this);
		logOut2.setOnClickListener(this);
		returnTicket.setOnClickListener(this);
		
		fullNameText.setText("Full name :\n\t" + fullName );
		accountNameText.setText("Signed in as :\n\t" + accountName);
		sourceText.setText("From : "+src);
		destinationText.setText("To : "+ dist);
		timeText.setText("Train Time : "+ time);
		priceText.setText(price);
	}
	
	public void onBackPressed() {

		return;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
//		reSubmit2 = (Button) findViewById(R.id.Submit2);
//		logOut2 = (Button) findViewById(R.id.logOut2);
		
		if(v.getId() == R.id.Submit2){
			Intent intent = new Intent(this, Second.class);
			intent.putExtra("fullName", fullName);
			intent.putExtra("nameStr", accountName);
			startActivity(intent);	
		}
		else if(v.getId() == R.id.logOut2){
			Toast.makeText(Tickets.this, "Buying ticket is confirmed successfully."
					, Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
		else if(v.getId() == R.id.returnTicket){
			Toast.makeText(Tickets.this, "Ticket has been returned successfully."
					, Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}	
}

