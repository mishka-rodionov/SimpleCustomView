package com.rodionov.simplecustomdraw;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.rodionov.simplecustomdraw.view.CompoundView;
import com.rodionov.simplecustomdraw.view.SimpleView;

public class CViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cview);

        final CompoundView compoundView = (CompoundView) this.findViewById(R.id.compound_view);


//        simpleView = (SimpleView) findViewById(R.id.simpleView);
////        simpleView.setSweepAngle(200);
//        final float sweepAngle = 200;
//
//        final ValueAnimator valueAnimator = new ValueAnimator().ofFloat(0, sweepAngle);
//        int duration = 2000;
//        valueAnimator.setDuration(duration);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                simpleView.setSweepAngle((float) animation.getAnimatedValue());
//            }
//        });
//        valueAnimator.setInterpolator(new BounceInterpolator());
//        valueAnimator.start();
//
        increment = (Button) findViewById(R.id.increment);
        decrement = (Button) findViewById(R.id.decrement);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dur = 2000;
                switch (v.getId()){
                    case R.id.increment:
                        compoundView.setCurrentValue(70);
//                        valueAnimator.setFloatValues(0, sweepAngle + 50);
//                        valueAnimator.setDuration(dur);
//                        valueAnimator.start();
////                        simpleView.increment();
////                        simpleView.invalidate();
                        break;
                    case R.id.decrement:
                        compoundView.setCurrentValue(30);
//                        valueAnimator.setFloatValues(0, sweepAngle - 50);
//                        valueAnimator.setDuration(dur);
//                        valueAnimator.start();
//                        simpleView.decrement();
//                        simpleView.invalidate();
                        break;
                }
            }
        };
        increment.setOnClickListener(onClickListener);
        decrement.setOnClickListener(onClickListener);

    }

    private Button increment;
    private Button decrement;
    private SimpleView simpleView;
}
