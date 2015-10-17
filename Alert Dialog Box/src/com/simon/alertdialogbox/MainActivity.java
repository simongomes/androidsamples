package com.simon.alertdialogbox;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	// Declare necessary variables
	Button btnAlert;
	AlertDialog.Builder dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Get the button from layout
		btnAlert = (Button) findViewById(R.id.btnAlert);
		
		// Instantiate the AlertDialog.Builder with its constructor
		dialog = new AlertDialog.Builder(this);
		
		// Set dialog Title (optional)
		dialog.setTitle("DIALOG TITLE");
		
		// Set dialog message
		dialog.setMessage("THIS IS DIALOG BOX MESSAGE");		
		
		// Set Positive Button
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "OK Button Clicked", Toast.LENGTH_LONG).show();	
			}
		});		
		
		// Set Negative Button
		dialog.setNeutralButton("NOT OK", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "NOT OK Button Clicked", Toast.LENGTH_LONG).show();
			}
		});
		
		// Set Negative Button
		dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Cancle Button Clicked", Toast.LENGTH_LONG).show();
			}
		});
		
		btnAlert.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				dialog.show();				
			}
		});
	}
}
