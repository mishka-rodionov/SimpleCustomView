package com.rodionov.simplecustomdraw.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Created by Lab on 21.08.2018.
 */

class DiagramView : View {

    private val backgroundRect: RectF
    private val backArcPaint: Paint
    private val frontArcPaint: Paint
    private var sweepAngle: Float = 0f
    private var strokeWidth: Float = 0f

    init {
        backgroundRect = RectF()

        backArcPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        frontArcPaint = Paint(Paint.ANTI_ALIAS_FLAG)

        backArcPaint.style = Paint.Style.STROKE
        backArcPaint.color = Color.LTGRAY

        frontArcPaint.style = Paint.Style.STROKE
        frontArcPaint.strokeCap = Paint.Cap.ROUND
        frontArcPaint.color = Color.RED

        sweepAngle = 270f
        strokeWidth = 30f

        frontArcPaint.strokeWidth = strokeWidth
        backArcPaint.strokeWidth = strokeWidth
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        backgroundRect.set(
                0f + strokeWidth /2,
                0f + strokeWidth /2,
                width.toFloat() - strokeWidth /2,
                height.toFloat() - strokeWidth /2)

        canvas.drawArc(backgroundRect, 0f, 360f, false, backArcPaint)
        canvas.drawArc(backgroundRect, -90f, sweepAngle, false, frontArcPaint)
    }

    fun setSweepAngle(value: Float) {
        this.sweepAngle = value
        invalidate()
    }

    fun setStrokeWidth(strokeWidth: Float){
        this.strokeWidth = strokeWidth
        this.frontArcPaint.strokeWidth = strokeWidth
        this.backArcPaint.strokeWidth = strokeWidth
        invalidate()
    }

    fun setArcColor(arcColor: Int){
        this.frontArcPaint.color = arcColor
        invalidate()
    }
}
