package com.bawei.zidingyibuju.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.zidingyibuju.R;
import com.bawei.zidingyibuju.view.LiuLayoutView;

import java.util.ArrayList;

public class LiuLayoutActivity extends AppCompatActivity {

    private LiuLayoutView liu_layout;
    private EditText edit_text;
    private Button btn_sousuo;
    private ArrayList<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liu_layout);
        edit_text =(EditText)findViewById(R.id.edit_text);
        btn_sousuo =(Button)findViewById(R.id.btn_sousuo);
        liu_layout =(LiuLayoutView)findViewById(R.id.liu_layout);

        //点击监听
        btn_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = edit_text.getText().toString().trim();
                if (!TextUtils.isEmpty(content)){
                    list.add(content);
                    liu_layout.setList(list);
                }
            }
        });

    }
}
