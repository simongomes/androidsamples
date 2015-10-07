package com.simon.passingdatawithinactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayGame extends Activity {
	
	private TextView textView;
	private Button endButton;
	private int answar;
	private String author;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_game);
		
		textView = (TextView) findViewById(R.id.result_text);
		endButton = (Button) findViewById(R.id.end_game); 
		
		// Get the Intent that started this activity
		Intent i = getIntent();
		
		// Get the values passed from the launcher activity
		answar = i.getIntExtra("meaningOfLife", -1); // returns -1 if not initialized by calling activity
		author = i.getStringExtra("userName"); //returns [] if not initialized by calling activity
		
		textView.setText( author + " : " + answar );
		
		answar = answar - 10;
		author = "Jr. " + author;
		
		endButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// Return Data to launcher activity
				Intent i = getIntent();
				i.putExtra("returnInt", answar);
				i.putExtra("returnStr", author);
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}
