package com.example.crawford.myclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cody Crawford on 2018-02-22.
 */

public class HourRing extends View {

    public HourRing(Context context) {
        this(context, null);
    }

    public HourRing(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HourRing(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public Paint textPaint;
    public Paint circlePaint;
    public Paint arcPaint;

    public Calendar ctime;
    public int Hours;
    public int radius;

    public void init(){
        initPaint();

        Hours = 0;
        radius = 350;
    }

    protected void initPaint(){
//        textPaint = new Paint();
//        textPaint.setColor(Color.rgb(0, 0, 255));
//        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        //textPaint.setStrokeWidth(200);
//        textPaint.setAntiAlias(true);
//        textPaint.setStrokeCap(Paint.Cap.ROUND);
//        textPaint.setTextSize(100);

        circlePaint = new Paint();
        circlePaint.setColor(Color.rgb(0, 100, 0));
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(30);

        arcPaint = new Paint();
        arcPaint.setColor(Color.rgb(0, 255, 255));
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(20);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        ctime = Calendar.getInstance();
        ctime.setTimeZone(TimeZone.getFrozenTimeZone("America/Edmonton"));
        Hours = ctime.get(Calendar.HOUR);

        //REMOVE - Debug
        //canvas.drawText(Integer.toString(Hours), 600,200,textPaint);
        //canvas.drawText(Integer.toString(GetHoursInDegrees()), getWidth()-300, getHeight()-500, textPaint);
        //

        canvas.drawCircle(getWidth()/2.0f, getHeight()/2.0f, radius, circlePaint);

        canvas.drawArc((getWidth()/2)-radius, (getHeight()/2)-radius, (getWidth()/2)+radius, (getHeight()/2)+radius, 270, GetHoursInDegrees(), false, arcPaint);

        invalidate();
    }


    public int GetHoursInDegrees(){
        return Hours * 360 / 12;
    }

}
