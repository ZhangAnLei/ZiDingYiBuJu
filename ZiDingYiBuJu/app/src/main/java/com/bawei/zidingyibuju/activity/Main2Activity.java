package com.bawei.zidingyibuju.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.zidingyibuju.view.ActionBarView;
import com.bawei.zidingyibuju.R;

public class Main2Activity extends AppCompatActivity {

    private ActionBarView action_bar_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        action_bar_view =(ActionBarView)findViewById(R.id.action_bar_view);
        action_bar_view.setTitle("我是第二个页面");
    }
}
