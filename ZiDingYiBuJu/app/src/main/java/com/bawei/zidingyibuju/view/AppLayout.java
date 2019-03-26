package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：描述信息
 */
public class AppLayout extends LinearLayout {
    //第一个是在代码中 实例化调用的
    public AppLayout(Context context) {
        super(context);
    }
    //在布局文件中引用的
    public AppLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //传一个样式
    public AppLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 位置  设置子view的一个位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    //view窗口可见
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
    //view窗口不可见

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
