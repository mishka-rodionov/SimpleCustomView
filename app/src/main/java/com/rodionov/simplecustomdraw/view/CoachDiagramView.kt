package com.rodionov.simplecustomdraw.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout

import com.rodionov.simplecustomdraw.R
import kotlinx.android.synthetic.main.coach_diagram_view.view.*

/**
 * Created by Lab on 22.08.2018.
 */

class CoachDiagramView : RelativeLayout {

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    init {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.coach_diagram_view, this)
        this.currentValue.text = "0"
        this.totalValue.text = "1"

    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        this.diagramView.setSweepAngle(Integer.parseInt(
                this.currentValue.text.toString()).toFloat() * 360 / Integer.parseInt(this.totalValue.text.toString()).toFloat())
    }

    fun setCurrentValue(currentValue: Int) {
        this.currentValue.text = Integer.toString(currentValue)
        onFinishInflate()
    }

    fun setTotalValue(totalValue: Int) {
        this.totalValue.text = Integer.toString(totalValue)
        onFinishInflate()
    }

    fun setStrokeWidth(strokeWidth: Float){
        this.diagramView.setStrokeWidth(strokeWidth)
    }

    fun setArcColor(arcColor: Int){
        this.diagramView.setArcColor(arcColor)
    }
}
