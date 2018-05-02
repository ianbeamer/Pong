package edu.sdsmt.beamer_i.pongBeamerIan;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

class PongView extends View {
    Thread GameThread = null;
    SurfaceHolder Holder;
    volatile boolean Playing;
    boolean Pause = true;
    Canvas Canvas;
    Paint Paint;
    long Frame;
    int ScreenX;
    int ScreenY;
    Bat Bat;
    Ball Ball;


    public PongView(Context context, int x, int y){
        super(context);

        ScreenX = x;
        ScreenY = y;

       // Holder = getHolder();
        Paint = new Paint();

        Bat = new Bat(ScreenX, ScreenY);
        Ball = new Ball(ScreenX, ScreenY);

        setupAndRestart();
    }

    public PongView(Context context) {
        super(context);
        setupAndRestart();
    }

    public PongView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAndRestart();
    }

    public PongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupAndRestart();
    }

    public void setupAndRestart(){
        ScreenX = Resources.getSystem().getDisplayMetrics().widthPixels;
        ScreenY = Resources.getSystem().getDisplayMetrics().heightPixels;

        // Holder = getHolder();
        Paint = new Paint();

        Bat = new Bat(ScreenX, ScreenY);
        Ball = new Ball(ScreenX, ScreenY);
        Ball.reset(ScreenX, ScreenY);
    }

    public void update(){
        Bat.update(0.05f);
        Ball.update(0.05f);
        if(ballInBat()) {
            Ball.reverseYVelocity();
            Ball.reverseXVelocity();
        }

    }

    public boolean ballInBat(){
        if(RectF.intersects(Bat.getRect(), Ball.getRect())){
            Ball.batBounce();
            Ball.reverseYVelocity();
            Ball.reverseYVelocity();
            Ball.increaseVelocity();
            Score.Score++;
            return true;
        }
        return false;
    }

    @Override
    public void onDraw(Canvas c){
        update();
        //Paint.setTextSize(40);
        c.drawColor(Color.argb(255, 0, 0, 0));
        Paint.setColor(Color.argb(255, 0, 255, 0));
        c.drawRect(Bat.getRect(), Paint);
        //c.drawRect(Ball.getRect(), Paint);
        Paint.setColor(Color.argb(255, 0, 255,0));
        Paint.setTextSize(40);
        c.drawRect(Ball.getRect(), Paint);
        c.drawRect(Bat.getRect(), Paint);
        c.drawText("Score: " + Score.Score, 10, 50, Paint);
        invalidate();
    }





    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                Pause = false;
                if(motionEvent.getX() > ScreenX / 2)
                    Bat.setMovementState(Bat.RIGHT);
                else
                    Bat.setMovementState(Bat.LEFT);
                break;

            case MotionEvent.ACTION_UP:
                Bat.setMovementState(Bat.STOP);
        }
        return true;
    }
}
