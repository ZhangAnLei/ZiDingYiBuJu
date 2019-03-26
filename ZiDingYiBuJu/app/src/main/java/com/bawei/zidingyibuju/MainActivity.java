package com.bawei.zidingyibuju;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.zidingyibuju.activity.CanvasActivity;
import com.bawei.zidingyibuju.activity.GuaGuaLeActivity;
import com.bawei.zidingyibuju.activity.LiuLayoutActivity;
import com.bawei.zidingyibuju.activity.Main2Activity;
import com.bawei.zidingyibuju.activity.RectActivity;
import com.bawei.zidingyibuju.activity.TuYaActivity;
import com.bawei.zidingyibuju.activity.WaterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_click).setOnClickListener(this);
        findViewById(R.id.btn_click2).setOnClickListener(this);
        findViewById(R.id.btn_click3).setOnClickListener(this);
        findViewById(R.id.btn_click4).setOnClickListener(this);
        findViewById(R.id.btn_click5).setOnClickListener(this);
        findViewById(R.id.btn_click6).setOnClickListener(this);
        findViewById(R.id.btn_click7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_click:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
            case R.id.btn_click2:
                startActivity(new Intent(MainActivity.this, CanvasActivity.class));
                break;
            case R.id.btn_click3:
                startActivity(new Intent(MainActivity.this, TuYaActivity.class));
                break;
            case R.id.btn_click4:
                startActivity(new Intent(MainActivity.this, GuaGuaLeActivity.class));
                break;
            case R.id.btn_click5:
                startActivity(new Intent(MainActivity.this, RectActivity.class));
                break;
            case R.id.btn_click6:
                startActivity(new Intent(MainActivity.this, WaterActivity.class));
                break;
            case R.id.btn_click7:
                startActivity(new Intent(MainActivity.this, LiuLayoutActivity.class));
                break;
        }
    }
}
