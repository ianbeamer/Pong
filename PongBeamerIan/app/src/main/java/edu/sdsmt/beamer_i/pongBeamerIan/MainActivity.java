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
    private Button pauseButton;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pauseButton = (Button)findViewById(R.id.button4);
        timer = new Timer();

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
        Intent intent = new Intent(this, ColorPicker.class);
        startActivity(intent);
        onResume();
    }

    public void tutorial(View view){
        onPause();
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
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
            //pauseButton.setText(R.string.pause);
            timer = new Timer();
        }
        else {
            Paused = true;
            timer.cancel();
            timer = null;
            //pauseButton.setText(R.string.start);
        }
    }
}
