package com.rodionov.simplecustomdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rodionov.simplecustomdraw.view.SimpleView;

public class CViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cview);

        simpleView = (SimpleView) findViewById(R.id.simpleView);

        increment = (Button) findViewById(R.id.increment);
        decrement = (Button) findViewById(R.id.decrement);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.increment:
                        simpleView.increment();
                        break;
                    case R.id.decrement:
                        simpleView.decrement();
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
