/*
ColorPicker
Ian Beamer

A color picker for the user to use

DOES NOT DO ANYTHING
 */

package edu.sdsmt.beamer_i.pongBeamerIan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.sdsmt.beamer_i.pongtest.R;

public class ColorPicker extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
    }
}
