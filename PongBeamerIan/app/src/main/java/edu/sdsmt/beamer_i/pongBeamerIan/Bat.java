/*
Bat
Ian Beamer

Holds the logic and creation of the bat in the game
 */

package edu.sdsmt.beamer_i.pongBeamerIan;

import android.graphics.RectF;

public class Bat {
    private RectF Rect;

    private float Length;
    private float Height;

    private float XCoord;
    private float YCoord;

    private float BatSpeed;

    public final int STOP = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;

    private int BatMoving = STOP;

    private int ScreenX;
    private int ScreenY;

    public Bat(int x, int y){
        ScreenX = x;
        ScreenY = y;

        Length = ScreenX / 6;
        Height = ScreenY / 50;

        XCoord = ScreenX / 2;
        YCoord = ScreenY - (ScreenY * .33f);

        Rect = new RectF(XCoord, YCoord, XCoord + Length, YCoord + Height);

        BatSpeed = ScreenX/2;
    }

    public RectF getRect(){
        return Rect;
    }

    public void setMovementState(int state){
        BatMoving = state;
    }

    public void update(float frame){
        if(BatMoving == LEFT)
            XCoord = XCoord - BatSpeed * frame;

        if(BatMoving == RIGHT)
            XCoord = XCoord + BatSpeed * frame;

        if(Rect.left < 0)
            XCoord = 0;

        if(Rect.right > ScreenX)
            XCoord = ScreenX - (Rect.right - Rect.left);

        Rect.left = XCoord;
        Rect.right = XCoord + Length;
    }
}
