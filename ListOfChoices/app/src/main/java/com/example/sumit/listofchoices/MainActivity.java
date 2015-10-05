package com.example.sumit.listofchoices;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    static final String[] ACTIVITY_CHOICES = new String[] {
            "OPTION 1", "OPTION 2", "OPTION 3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        final Context context = getApplicationContext();

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, ACTIVITY_CHOICES));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setTextFilterEnabled(true);

        getListView().setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                switch(arg2) {//extend switch to as many as needed
                    case 0:
                        //code for action 1
                        Toast.makeText(context, "OPTION 1 SELECTED", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(context, "OPTION 2 SELECTED", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(context, "OPTION 2 SELECTED", Toast.LENGTH_LONG).show();
                        break;
                    default: break;
                }
            }
        });
    }
}
