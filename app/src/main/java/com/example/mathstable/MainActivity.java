package com.example.mathstable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int value;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = findViewById(R.id.myListView);
        SeekBar  seekbar    = findViewById(R.id.seekBar);
        seekbar.setMax(20);
        seekbar.setProgress(10);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timetablenum;
                if(progress<min){
                    timetablenum = 1;
                    seekbar.setProgress(min);
                }
                else {
                    timetablenum = progress;
                }
                Log.i("seek bar value",Integer.toString(timetablenum));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}