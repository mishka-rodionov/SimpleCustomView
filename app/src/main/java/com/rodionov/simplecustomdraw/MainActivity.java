package com.rodionov.simplecustomdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lab on 21.08.2018.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cview = (Button) findViewById(R.id.cview);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cview:
                        Intent intent = new Intent(MainActivity.this, CViewActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        cview.setOnClickListener(onClickListener);
    }

    private Button cview;
}
