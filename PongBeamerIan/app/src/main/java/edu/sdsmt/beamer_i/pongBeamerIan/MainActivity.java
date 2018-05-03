/*
MainActivity
Ian Beamer

Main holder for the entire program, has the functions to run the main window and the button presses

 */

package edu.sdsmt.beamer_i.pongBeamerIan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import edu.sdsmt.beamer_i.pongtest.R;

public class MainActivity extends AppCompatActivity {
    boolean Paused = false;

    //an onCreate override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Score.Score = 0;
        setContentView(R.layout.activity_main);

    }

    //an override of the onResume function
    @Override
    protected void onResume(){
        super.onResume();
    }

    //an override of the onPause function
    @Override
    protected void onPause(){
        super.onPause();
    }

    //opens up a nonexistent color picker
    public void colorPicker(View view){
        onPause();
        Intent intent = new Intent(this, ColorPicker.class);
        startActivity(intent);
        onResume();
    }

    //opens up the extremely clear tutorial
    public void tutorial(View view){
        onPause();
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
        onResume();
    }

    //tries to reset the game and the score
    public void resetGame(View view){
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Score.Score = 0;
        startActivity(i);
        //Doesn't reset the score
    }

    //tries to pause/unpause the game
    public void pauseGame(View view){
        if(Paused) {
            Paused = false;
            //timer = new Timer();
            //onResume() not working
            onResume();
        }
        else {
            Paused = true;
            //timer.cancel();
            //timer = null;
            //onPause() not working right
            onPause();
        }
    }
}
