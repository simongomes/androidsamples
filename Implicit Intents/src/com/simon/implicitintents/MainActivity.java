package com.simon.implicitintents;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	// Create list options as a String Array
	final String[] LIST_OPTION = new String[]{
		"Open Website Example",
		"Open Contacts",
		"Open Phone Dialer Example",
		"Search Google Example",
		"Start Voice Command",
		"Open Messaging"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Get ListView from the layout
		ListView listView = (ListView) findViewById(R.id.listView1);
		
		// Create Adapter(ArrayAdapter) for ListView
		ArrayAdapter<String> options = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LIST_OPTION );
		
		// Set adapter to the ListView
		listView.setAdapter(options);
		
		// Set ListView item onClick listener
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				switch(arg2) {
				case 0: // Open web browser and navigate to the given site
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")));
					break;
				case 1: // Open contacts application to browse contact
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")));
					break;
				case 2: // Open phone dialer and fill up with given number
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801679207360")));
					break;
				case 3: // Search google
					Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
					intent.putExtra(SearchManager.QUERY, "Android");
					startActivity(intent);
					break;
				case 4: // Open voice commander
					startActivity(new Intent(Intent.ACTION_VOICE_COMMAND));
					break;
				case 5: // Open Messaging app
					Intent msg_intent = new Intent(Intent.ACTION_MAIN);
					msg_intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
					startActivity(msg_intent);
					break;
				default: break;
				}
			}
		});
	}
}
