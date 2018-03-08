package com.example.crawford.myclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cody Crawford on 2018-02-22.
 */

public class SecondRing extends View {

    public SecondRing(Context context) {
        this(context, null);
    }

    public SecondRing(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecondRing(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public Paint textPaint;
    public Paint circlePaint;
    public Paint arcPaint;

    public Calendar ctime;
    public int seconds;
    public int radius;

    public void init(){
        initPaint();

        seconds = 0;
        radius = 150;
    }

    protected void initPaint(){

        circlePaint = new Paint();
        circlePaint.setColor(Color.rgb(125, 0, 0));
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(30);

        arcPaint = new Paint();
        arcPaint.setColor(Color.rgb(255, 255, 0));
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(20);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        ctime = Calendar.getInstance();
        seconds = ctime.get(Calendar.SECOND);

        canvas.drawCircle(getWidth()/2.0f, getHeight()/2.0f, radius, circlePaint);

        canvas.drawArc((getWidth()/2)-radius, (getHeight()/2)-radius, (getWidth()/2)+radius, (getHeight()/2)+radius, 270, GetSecondsInDegrees(), false, arcPaint);

        invalidate();
    }


    public int GetSecondsInDegrees(){
        return seconds * 360 / 60;
    }

}
