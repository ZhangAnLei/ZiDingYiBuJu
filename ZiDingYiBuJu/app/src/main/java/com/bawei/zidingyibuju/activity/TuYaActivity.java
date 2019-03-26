package com.bawei.zidingyibuju.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.zidingyibuju.R;
import com.bawei.zidingyibuju.view.TuYaView;

public class TuYaActivity extends AppCompatActivity implements View.OnClickListener {

    private TuYaView tuya_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_ya);
        findViewById(R.id.btn_red).setOnClickListener(this);
        findViewById(R.id.btn_white).setOnClickListener(this);
        findViewById(R.id.btn_yellow).setOnClickListener(this);
        tuya_view =(TuYaView)findViewById(R.id.tuya_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_red:
                tuya_view.setColor(Color.RED);
                break;
            case R.id.btn_white:
                tuya_view.setColor(Color.WHITE);
                break;
            case R.id.btn_yellow:
                tuya_view.setColor(Color.YELLOW);
                break;
        }
    }
}
