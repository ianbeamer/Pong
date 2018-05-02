package edu.sdsmt.beamer_i.pongBeamerIan;

import android.graphics.RectF;

import java.util.Random;

public class Ball {
    private RectF rect;
    private float XVelocity;
    private float YVelocity;
    private float BallWidth;
    private float BallHeight;
    private int ScreenX, ScreenY;

    public Ball(int screenX, int screenY){
        //make ball size relative to screen
        BallWidth = screenX / 50;
        BallHeight = BallWidth;
        ScreenX = screenX;
        //start with the ball traveling upwards
        YVelocity = screenY / 10;
        XVelocity = YVelocity + setRandomXVelocity();
        ScreenY = screenY;

        rect = new RectF(ScreenX/2,0, ScreenX/2 + 100, 50);
    }

    public RectF getRect(){
        return rect;
    }

    public void update(float frame){
        rect.left = rect.left + (XVelocity * frame);
        rect.top = rect.top + (YVelocity * frame);
        rect.right = rect.left + BallWidth;
        rect.bottom = rect.top - BallHeight;

        //if on left side of screen, reverse x velocity
        if(rect.left <= 0)
            reverseXVelocity();
        //if on right, reverse x velocity
        if(rect.right >= ScreenX)
            reverseXVelocity();
        //if on top, reverse y velocity
        if(rect.top <= 0)
            reverseYVelocity();
        //if on bottom, reset to original position,
        if(rect.bottom >= ScreenY) {
            rect = new RectF(ScreenX/2,0, ScreenX/2 + 100, 50);
            YVelocity = ScreenY / 10;
            XVelocity = YVelocity + setRandomXVelocity();
            Score.Score = 0;
        }
    }

    public void reverseYVelocity(){
        YVelocity = -YVelocity;
    }

    public void reverseXVelocity(){
        XVelocity = -XVelocity;
    }

    public void clearObstacleY(float y){
        //rect.bottom = y;
        //rect.top = y - BallHeight;
    }

    public void clearObstacleX(float x){
        //rect.left = x;
        //rect.right = x + BallWidth;
    }

    public void reset(int x, int y){
//        rect.left = x / 2;
//        rect.top = y - 20;
//        rect.right = x / 2 + BallWidth;
//        rect.bottom = y - 20 - BallHeight;
    }

    public int setRandomXVelocity(){
        Random gen = new Random();
        int ans = gen.nextInt(51);

        Random tst = new Random();
        int neg = tst.nextInt(2);
        if(neg == 1)
            ans = -ans;

        return ans;
    }

    public void increaseVelocity(){
        XVelocity = XVelocity + XVelocity / 50;
        YVelocity = YVelocity + YVelocity / 50;
    }

    public void batBounce(){
        XVelocity = setRandomXVelocity();
    }
}


