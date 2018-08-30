package com.rodionov.simplecustomdraw.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Created by Lab on 30.08.2018.
 */
class CustomTextView : View{
    private val backgroundRect: RectF
    private val paint: Paint

    init {
        backgroundRect = RectF()

        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        backgroundRect.set(0f, 0f, width.toFloat(), height.toFloat())

        canvas.drawRoundRect(backgroundRect, 30f, 30f, paint)

    }
}