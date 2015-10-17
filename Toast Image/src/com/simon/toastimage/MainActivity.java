package com.simon.toastimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView imageView;;
	Toast imageToast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageToast = Toast.makeText(this, "text", Toast.LENGTH_LONG);
		imageView = new ImageView(this);
		imageView.setImageResource(R.drawable._avatar);
		imageToast.setView(imageView);
		imageToast.setGravity(Gravity.CENTER, imageToast.getXOffset()/2, imageToast.getYOffset()/2);
		
		Button btnFindMe = (Button) findViewById(R.id.btnFindMe);
		btnFindMe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageToast.show();
			}
		});
		
	}
}
