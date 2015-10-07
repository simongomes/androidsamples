package com.simon.passingdatawithinactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final int PLAY_GAME = 1010;
	private TextView textView;
	private EditText author;
	private int meaningOfLife = 42;
	private String userName = "Doglas Adam";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		// Get TextView view from layout
		textView = (TextView) findViewById(R.id.startscreen_text);
		// Get EditText view from layout
		author = (EditText) findViewById(R.id.author_name);
		// Display Initial Values
		textView.setText( userName + " : " + meaningOfLife );
		
		// Set Play button click listener
		Button playBtn = (Button) findViewById(R.id.play_button);
		playBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startGame();
			}			
		});
			
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == PLAY_GAME && resultCode == RESULT_OK) {
			meaningOfLife = data.getExtras().getInt("returnInt");
			userName = data.getExtras().getString("returnStr");			
			// Show it has changed
			textView.setText( userName + " : " + meaningOfLife );
		}
	}
	
	private void startGame() {
		Intent intent = new Intent(this, PlayGame.class);
		
		// Get the value from Author EditText field
		userName = author.getText().toString();
		
		// Pushing data to lunched activity
		intent.putExtra("meaningOfLife", meaningOfLife);
		intent.putExtra("userName", userName);
		
		startActivityForResult(intent, PLAY_GAME);
	}
	
}
