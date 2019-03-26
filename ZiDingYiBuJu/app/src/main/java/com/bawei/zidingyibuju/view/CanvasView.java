package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：了解自定义view
 * 测量   位置   绘制
 * onMeasure   onLayout   onDraw
 */
public class CanvasView extends View {
    private Paint paint,paint1,paint2,paint3;

    public CanvasView(Context context) {
        super(context);
        Log.i("aaa","构造"+"=====1");
        init(context);

    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i("aaa","构造"+"=====2");
        init(context);
    }

    //初始化   在自定义view中主要初始化画笔  路径等
    private void init(Context context) {
        //设置背景颜色
        setBackgroundColor(Color.parseColor("#222222"));
        //实例化画笔
        paint=new Paint();
        paint.setColor(Color.WHITE);//设置字体颜色
        paint.setTextSize(36);//设置文字的大小
        paint.setStrokeWidth(10);//设置画笔线的宽度(粗细)
        paint.setAntiAlias(true);//设置画笔的抗锯齿  让线变得更润滑
        paint.setTextAlign(Paint.Align.CENTER);//设置画布的文字居中
    }

    //绘制的方法  canvas-->画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("aaa","onDraw"+"=====1");
        //常见的几种方法
        getWidth();//获取手机的宽度
        getRight();//获取手机的宽度
        getHeight();//获取手机的高度
        getBottom();//获取手机的高度
        getLeft();//距离左边
        getTop();//距离上边
        //绘制文字
        canvas.drawText("了解自定义view",getRight()/2,50,paint);

        //绘制线
        paint1=new Paint();
        paint1.setTextSize(5);
        paint1.setColor(Color.RED);
        canvas.drawLine(0,70,getWidth(),70,paint1);
        canvas.drawLine(100,70,100,getBottom(),paint1);


        //绘制圆
        paint2=new Paint();
        paint2.setColor(Color.WHITE);
        //画笔的粗细
        paint2.setStrokeWidth(10);
        //设置抗锯齿
        paint2.setAntiAlias(true);
        //绘制空心的画笔  Paint.Style.FILL---》实心
        paint2.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getRight()/2,getBottom()/2,100,paint2);

        //绘制矩形
        Rect rect = new Rect();
        rect.left=100;
        rect.top=200;
        rect.bottom=400;
        rect.right=300;
        paint3=new Paint();
        //抗抗锯齿
        paint3.setAntiAlias(true);
        //空心
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setColor(Color.WHITE);
        paint3.setStrokeWidth(8);

        canvas.drawRect(rect,paint3);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("aaa","onMeasure"+"=====1");
        //获取模式   三种模式
        //android.view.View.MeasureSpec#UNSPECIFIED},
        // 未指定模式 父容器不限制view的大小，一般用于系统内部测量
        //android.view.View.MeasureSpec#AT_MOST} or
        //最大模式   设置包裹内容就返回最大模式
        //android.view.View.MeasureSpec#EXACTLY}
        //精确模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);

        if (mode==MeasureSpec.AT_MOST){
            Log.i("aaa","最大"+"=====");
        }else if(mode==MeasureSpec.EXACTLY){
            Log.i("aaa","精确"+"=====");
            //通过判断模式来重新设置view的大小
            //setMeasuredDimension(widthMeasureSpec/2,heightMeasureSpec/2);
        }else{
            Log.i("aaa","未指定"+"=====");
        }
        //获取你所设置view的宽和高
        int width = MeasureSpec.getSize(heightMeasureSpec);
        int height = MeasureSpec.getSize(widthMeasureSpec);
        //设置view的宽和高setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    // 位置  设置子view的一个位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("aaa","onAttached"+"=====1");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("aaa","onDetached"+"=====1");
    }
}
