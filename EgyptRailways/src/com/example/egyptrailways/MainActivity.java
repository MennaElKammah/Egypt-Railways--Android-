package com.example.egyptrailways;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	ArrayList<usersList> ArrList = new ArrayList<usersList>();

	EditText name ;
	EditText password ;
	EditText newfullName ;
	EditText newName ;
	EditText newPassword ;
	Button login ;
	Button signUp ;
	Button cancel ;
	Users[] users = new Users[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		name = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		newfullName = (EditText) findViewById(R.id.fullName);
		newName = (EditText) findViewById(R.id.newName);
		newPassword = (EditText) findViewById(R.id.newPassword);
		login = (Button) findViewById(R.id.loginBtn);
		signUp = (Button) findViewById(R.id.signUpNowBtn);
		cancel = (Button) findViewById(R.id.cancelBtn);
		login.setOnClickListener(this);
		signUp.setOnClickListener(this);
		cancel.setOnClickListener(this);
		ArrList.add(new usersList("Menna ElKammah","mennats","m3107"));
		ArrList.add(new usersList("Basma Taha" , "basma" , "#2015"));
		ArrList.add(new usersList("Sherouk Hossam" , "Sherouk" , "123456"));
		ArrList.add(new usersList("Asmaa Osama Kamal" , "Asmaa" , "asmaa"));
		name.setText("");
		password.setText("");


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

	public void onBackPressed() {

		return;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String nameStr = name.getText().toString();
		String passStr = password.getText().toString();
		String fullName ;
		boolean found = false ;
		switch (v.getId()) {
		case R.id.loginBtn :
			for (int i=0 ; i<ArrList.size(); i++)
			{
				if (nameStr.equals(ArrList.get(i).userName.toString()) 
						&& passStr.equals(ArrList.get(i).password.toString()))
				{
					found = true ;
					fullName = ArrList.get(i).fullName.toString();
					Intent intent = new Intent(this,Second.class);
					intent.putExtra("fullName", fullName);
					intent.putExtra("nameStr", nameStr);
					startActivity(intent);
				}
			}
			if (!found)
			{
				name.setText("");
				password.setText("");
				Toast.makeText(MainActivity.this, "Invalid Username or Password."
						, Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.signUpNowBtn :
			String newFullNAmeStr = newfullName.getText().toString();
			String newNameStr = newName.getText().toString();
			String newPasswordStr = newPassword.getText().toString();
			ArrList.add(new usersList(newFullNAmeStr , newNameStr , newPasswordStr));
			Toast.makeText(MainActivity.this, "Signing up successfully."
					, Toast.LENGTH_LONG).show();
			name.setText("");
			password.setText("");
			newName.setText("");
			newfullName.setText("");
			newPassword.setText("");
			break;
			
		case R.id.cancelBtn :
			name.setText("");
			password.setText("");
			break;
		default :
			break;
		}
	}
}
