package com.rodionov.simplecustomdraw.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.rodionov.simplecustomdraw.R
import kotlinx.android.synthetic.main.coach_diagram_view.view.*

/**
 * Created by Lab on 30.08.2018.
 */
class CustomCompoundView: RelativeLayout {

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    init {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.custom_compound_view, this)

    }

    override fun onFinishInflate() {
        super.onFinishInflate()

    }
}