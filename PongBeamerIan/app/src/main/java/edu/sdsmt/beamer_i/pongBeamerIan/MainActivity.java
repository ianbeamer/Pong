package edu.sdsmt.beamer_i.pongBeamerIan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.sdsmt.beamer_i.pongtest.R;

public class MainActivity extends AppCompatActivity {
    boolean Paused = false;

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

    public void colorPicker(View view){
        onPause();
        //open that window
        onResume();
    }

    public void tutorial(View view){
        onPause();
        //open that window
        onResume();
    }

    public void resetGame(View view){
        Score.Score = 0;
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void pauseGame(View view){
        if(Paused) {
            Paused = false;
            onResume();
        }
        else {
            Paused = true;
            onPause();
        }
    }
}
