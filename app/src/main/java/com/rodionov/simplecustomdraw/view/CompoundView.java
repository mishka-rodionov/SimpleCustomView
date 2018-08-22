package com.rodionov.simplecustomdraw.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rodionov.simplecustomdraw.R;

import org.w3c.dom.Text;

/**
 * Created by Lab on 22.08.2018.
 */

public class CompoundView extends RelativeLayout implements Compound {

    private SimpleView simpleView;
    private TextView currentValue;
    private TextView totalValue;

    public CompoundView(Context context) {
        super(context);
        initializeViews(context);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.compound_view, this);
        simpleView = (SimpleView) this.findViewById(R.id.simpleView_CV);
        currentValue = (TextView) this.findViewById(R.id.currentValue);
        totalValue = (TextView) this.findViewById(R.id.totalValue);
        currentValue.setText("52");
        totalValue.setText("90");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        simpleView.setStep(360 / Integer.parseInt(totalValue.getText().toString()));
        simpleView.setSweepAngle(Integer.parseInt(currentValue.getText().toString()));
    }

    @Override
    public void setCurrentValue(int currentValue) {
        this.currentValue.setText(Integer.toString(currentValue));
        onFinishInflate();
    }

    @Override
    public void setTotalValue(int totalValue) {
        this.totalValue.setText(totalValue);
        onFinishInflate();
    }
}
