package com.bawei.zidingyibuju.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bawei.zidingyibuju.R;
import com.bawei.zidingyibuju.view.WaterView;

//自定义水波纹   让头像随着水波纹移动
public class WaterActivity extends AppCompatActivity {

    private ImageView image;
    private WaterView water_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        image =(ImageView)findViewById(R.id.image);
        water_view =(WaterView)findViewById(R.id.water_view);

        water_view.setAnimatorListener(new WaterView.AnimatorListener() {
            @Override
            public void Animator(float y) {
                RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) image.getLayoutParams();
                params.setMargins(0, (int) y,0,0);
                image.setLayoutParams(params);

            }
        });
    }
}
