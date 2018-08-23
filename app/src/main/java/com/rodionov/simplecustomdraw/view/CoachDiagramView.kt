package com.rodionov.simplecustomdraw.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView

import com.rodionov.simplecustomdraw.R

/**
 * Created by Lab on 22.08.2018.
 */

class CoachDiagramView : RelativeLayout {

    private var diagramView: DiagramView?
    private var currentValue: TextView?
    private var totalValue: TextView?

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    init {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.coach_diagram_view, this)
        diagramView = this.findViewById<DiagramView>(R.id.diagramView)
        currentValue = this.findViewById<TextView>(R.id.currentValue)
        totalValue = this.findViewById<TextView>(R.id.totalValue)
        currentValue!!.text = "0"
        totalValue!!.text = "1"

    }


    override fun onFinishInflate() {
        super.onFinishInflate()

        diagramView!!.setStep((360 / Integer.parseInt(totalValue!!.text.toString())).toFloat())
        diagramView!!.setSweepAngle(Integer.parseInt(currentValue!!.text.toString()).toFloat())
    }

    fun setCurrentValue(currentValue: Int) {
        this.currentValue!!.text = Integer.toString(currentValue)
        onFinishInflate()
    }

    fun setTotalValue(totalValue: Int) {
        this.totalValue!!.text = Integer.toString(totalValue)
        onFinishInflate()
    }

    fun setStrokeWidth(strokeWidth: Float){
        this.diagramView!!.setStrokeWidth(strokeWidth)
    }

    fun setArcColor(arcColor: Int){
        this.diagramView!!.setArcColor(arcColor)
    }
}
