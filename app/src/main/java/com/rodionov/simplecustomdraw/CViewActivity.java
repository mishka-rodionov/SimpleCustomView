package com.rodionov.simplecustomdraw;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rodionov.simplecustomdraw.view.CoachDiagramView;

public class CViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cview);

        final CoachDiagramView coachDiagrammView = (CoachDiagramView) this.findViewById(R.id.coachDiagramView);

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
                        coachDiagrammView.setCurrentValue(70);
                        coachDiagrammView.setTotalValue(90);
                        coachDiagrammView.setStrokeWidth(100);
                        coachDiagrammView.setArcColor(Color.GREEN);
//                        valueAnimator.setFloatValues(0, sweepAngle + 50);
//                        valueAnimator.setDuration(dur);
//                        valueAnimator.start();
////                        simpleView.increment();
////                        simpleView.invalidate();
                        break;
                    case R.id.decrement:
                        coachDiagrammView.setCurrentValue(30);
                        coachDiagrammView.setStrokeWidth(10);
                        coachDiagrammView.setTotalValue(90);
                        coachDiagrammView.setArcColor(Color.BLUE);
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
}
