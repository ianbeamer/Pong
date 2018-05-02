package edu.sdsmt.beamer_i.pongBeamerIan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.sdsmt.beamer_i.pongtest.R;

public class MainActivity extends AppCompatActivity {
    PongView pongView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
}
