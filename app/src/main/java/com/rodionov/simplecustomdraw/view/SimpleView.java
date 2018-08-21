package com.rodionov.simplecustomdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.ArcShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lab on 21.08.2018.
 */

public class SimpleView extends View implements Simple{

    private RectF backgroundRect;
    private ArcShape arcShape;
    private Paint backgrounPaint;
    private Paint arcBackgrounPaint;
    private float sweepAngle = 360;

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        arcShape = new ArcShape(0, 360);

        sweepAngle = 270;

        backgroundRect = new RectF();
        backgrounPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcBackgrounPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        final int canvasWidth = canvas.getWidth();
        final int canvasHeight = canvas.getHeight();

        final float canvasCenterWidth = canvasWidth * 0.5f;
        final float canvasCenterHeight = canvasHeight * 0.5f;

        backgroundRect.set(canvasWidth * .25f, canvasHeight * .75f, canvasWidth * .75f, canvasWidth * .25f);
//        backgroundRect.set();
        backgrounPaint.setColor(Color.LTGRAY);
//        sweepAngle = 360;
//        canvas.drawRect(backgroundRect, backgrounPaint);
//        canvas.drawCircle(canvasCenterWidth, canvasCenterHeight,
//                canvasCenterHeight / 2, backgrounPaint);
        arcBackgrounPaint.setStyle(Paint.Style.STROKE);
        arcBackgrounPaint.setStrokeWidth(12);
        arcBackgrounPaint.setColor(Color.BLACK);
        canvas.drawArc(backgroundRect, 0, sweepAngle, false, arcBackgrounPaint);
    }

    @Override
    public void increment() {
        this.sweepAngle += 10;
    }

    @Override
    public void decrement() {
        this.sweepAngle -= 10;
    }
}
