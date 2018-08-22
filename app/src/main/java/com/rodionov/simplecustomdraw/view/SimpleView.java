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
    private Paint backArcPaint;
    private Paint frontArcPaint;
    private Paint arcBackgrounPaint;
    private float sweepAngle;
    private float step;

    private int measuredWidth;
    private int measuredHeight;
    private int minMeasuredSize;
    private float strokeWidth;

    private int SIZE_FACTOR = 15;

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        sweepAngle = 270;
        strokeWidth = 30;
        step = 1;

        backgroundRect = new RectF();
        arcBackgrounPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        frontArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    /**
     * Reconcile a desired size for the view contents with a {@link android.view.View.MeasureSpec}
     * constraint passed by the parent.
     *
     * Simplified version of {@link View#resolveSizeAndState(int, int, int)}.
     *
     * @param contentSize Size of the view's contents.
     * @param measureSpec A {@link android.view.View.MeasureSpec} passed by the parent.
     * @return A size that best fits {@code contentSize} while respecting the parent's constraints.
     */
    private int reconcileSize(int contentSize, int measureSpec) {
        final int mode = MeasureSpec.getMode(measureSpec);
        final int specSize = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                return specSize;
            case MeasureSpec.AT_MOST:
                if (contentSize < specSize) {
                    return contentSize;
                } else {
                    return specSize;
                }
            case MeasureSpec.UNSPECIFIED:
            default:
                return contentSize;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measuredWidth = reconcileSize(200, widthMeasureSpec);
        measuredHeight = reconcileSize(200, heightMeasureSpec);

        if (measuredWidth > measuredHeight){
            minMeasuredSize = measuredHeight;
        }else{
            minMeasuredSize = measuredWidth;
        }

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int canvasWidth = canvas.getWidth();
        final int canvasHeight = canvas.getHeight();

        float rectSide;

        final float canvasCenterWidth = canvasWidth * 0.5f;
        final float canvasCenterHeight = canvasHeight * 0.5f;

        if (canvasCenterWidth > canvasCenterHeight){
            if (minMeasuredSize > canvasCenterHeight){
                rectSide = canvasCenterHeight / 2;
                strokeWidth = canvasCenterHeight / SIZE_FACTOR;
            }else{
                rectSide = minMeasuredSize / 2;
                strokeWidth = minMeasuredSize / SIZE_FACTOR;
            }
        }else {
            if (minMeasuredSize > canvasCenterWidth){
                rectSide = canvasCenterWidth / 2;
                strokeWidth = canvasCenterWidth / SIZE_FACTOR;
            }else{
                rectSide = minMeasuredSize / 2;
                strokeWidth = minMeasuredSize / SIZE_FACTOR;
            }
        }

        backgroundRect.set(canvasCenterWidth - rectSide/*canvasCenterHeight / 2 + 15*/,
                canvasCenterHeight - rectSide/*canvasCenterHeight / 2 + 15*/,
                canvasCenterWidth + rectSide/*canvasCenterHeight / 2 - 15*/,
                canvasCenterHeight + rectSide/*canvasCenterHeight / 2 - 15*/);
//        backgroundRect.set(0f, 0f, canvasWidth, canvasHeight);

        backArcPaint.setStyle(Paint.Style.STROKE);
        backArcPaint.setStrokeWidth(strokeWidth);
        backArcPaint.setColor(Color.LTGRAY);

        frontArcPaint.setStyle(Paint.Style.STROKE);
        frontArcPaint.setStrokeWidth(strokeWidth);
        frontArcPaint.setStrokeCap(Paint.Cap.ROUND);
        frontArcPaint.setColor(Color.RED);
        canvas.drawArc(backgroundRect, 0, 360, false, backArcPaint);
        canvas.drawArc(backgroundRect, -90, sweepAngle, false, frontArcPaint);
    }

    @Override
    public void setSweepAngle(float value) {
        this.sweepAngle = value * step;
        invalidate();
    }

    @Override
    public void setStep(float step) {
        this.step = step;
    }
}
