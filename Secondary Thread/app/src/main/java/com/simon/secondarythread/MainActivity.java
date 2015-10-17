package com.simon.secondarythread;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.trigger);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // standalone play_music() function call causes main thread to hang.
                // Instead, create separate thread for time consuming task.

                Thread initBkdgThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        play_music();
                    }
                });
                initBkdgThread.start();
            }
        });

    }

    int[] notes = {R.raw.c5, R.raw.b4, R.raw.a4, R.raw.g4};
    int NOTE_DURATION = 400; //millisecond
    MediaPlayer m_mediaPlayer;
    private void play_music() {
        for( int ii = 0; ii < 12; ii++ ) {
            // Check to ensure main activity is not paused
            if(!paused) {
                if(m_mediaPlayer != null) {m_mediaPlayer.release();}
                m_mediaPlayer = MediaPlayer.create(this, notes[ii%4]);
                m_mediaPlayer.start();
                try {
                    Thread.sleep(NOTE_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    } // end play_music()

    boolean paused = false;

    @Override
    protected void onPause() {
        paused = true;
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        paused = false;
    }
}
