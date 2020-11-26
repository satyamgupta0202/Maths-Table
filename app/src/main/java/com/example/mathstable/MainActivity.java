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
    ListView myListView;
    public void generate (int timetablenum){
        ArrayList<String> tt = new ArrayList<>();
        for(int j=1;j<=10;j++) {
            tt.add(Integer.toString(j*timetablenum));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, tt);
        myListView.setAdapter(arrayAdapter);
        Log.i("seek bar value",Integer.toString(timetablenum));
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.myListView);
        SeekBar  seekbar    = findViewById(R.id.seekBar);
        int max = 20;
        int curr = 10;
        seekbar.setMax(max);
        seekbar.setProgress(curr);

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
                generate(timetablenum);
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