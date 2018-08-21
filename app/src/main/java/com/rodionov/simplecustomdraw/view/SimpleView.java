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
    private Paint backgrounCircle;
    private Paint arcBackgrounPaint;
    private Paint paint;
    private float sweepAngle;

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        sweepAngle = 270;

        backgroundRect = new RectF();
        backgrounPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgrounCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcBackgrounPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int canvasWidth = canvas.getWidth();
        final int canvasHeight = canvas.getHeight();

        final float canvasCenterWidth = canvasWidth * 0.5f;
        final float canvasCenterHeight = canvasHeight * 0.5f;

//        backgroundRect.set(canvasWidth * .25f, canvasHeight * .75f, canvasWidth * .75f, canvasWidth * .25f);
        backgroundRect.set(canvasCenterWidth - canvasCenterHeight / 2 + 15,
                canvasCenterHeight - canvasCenterHeight / 2 + 15,
                canvasCenterWidth + canvasCenterHeight / 2 - 15,
                canvasCenterHeight + canvasCenterHeight / 2 - 15);
//        backgroundRect.set();
        backgrounCircle.setColor(Color.LTGRAY);
//        sweepAngle = 360;
//        canvas.drawRect(backgroundRect, backgrounPaint);
        canvas.drawCircle(canvasCenterWidth, canvasCenterHeight,
                canvasCenterHeight / 2, backgrounCircle);
        backgrounCircle.setColor(Color.WHITE);
        canvas.drawCircle(canvasCenterWidth, canvasCenterHeight,
                canvasCenterHeight / 2 - 30, backgrounCircle);
        arcBackgrounPaint.setStyle(Paint.Style.STROKE);
        arcBackgrounPaint.setStrokeWidth(30);
        arcBackgrounPaint.setStrokeCap(Paint.Cap.ROUND);
        arcBackgrounPaint.setColor(Color.RED);
        canvas.drawArc(backgroundRect, -90, sweepAngle, false, arcBackgrounPaint);
//        final RectF oval = new RectF();
//        paint.setStyle(Paint.Style.STROKE);
//  /*
//   * drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
//   *
//   * oval - The bounds of oval used to define the shape and size of the arc
//   * startAngle - Starting angle (in degrees) where the arc begins
//   * sweepAngle - Sweep angle (in degrees) measured clockwise
//   * useCenter - If true, include the center of the oval in the arc, and close it if it is being stroked. This will draw a wedge
//   * paint - The paint used to draw the arc
//   */
//        oval.set(50, 50, 150, 150);
//        canvas.drawArc(oval, 0, 45, true, paint);
//
//        oval.set(200, 150, 450, 350);
//        canvas.drawArc(oval, 0, 270, true, paint);
//
//        oval.set(200, 400, 450, 600);
//        canvas.drawArc(oval, 0, 270, false, paint);
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
