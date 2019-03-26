package com.bawei.zidingyibuju.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.zidingyibuju.R;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：定义每个页面展示的title
 */
public class ActionBarView extends RelativeLayout {

    private TextView text_title;

    public ActionBarView(Context context) {
        super(context);
        init(context);
    }

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BannerViewStyle);
        //通过typedArray获取自定义文件中的属性
        int time = typedArray.getInteger(R.styleable.BannerViewStyle_time, 3000);
        boolean startOtStop = typedArray.getBoolean(R.styleable.BannerViewStyle_startOtStop, false);
        //获取完事后尽量将属性进行释放
        typedArray.recycle();

        init(context);
    }

    public ActionBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    //初始化
    private void init(final Context context) {
        View view = View.inflate(context, R.layout.action_bar, null);
        view.findViewById(R.id.image_back).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
            }
        });
        text_title =(TextView)view.findViewById(R.id.text_title);
        addView(view);

    }
    //动态的改变title的值   设置标题
    public void setTitle(String title){
        if (TextUtils.isEmpty(title)){
            return;
        }
        text_title.setText(title);
    }
}
