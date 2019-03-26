package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：描述信息
 */
public class TuYaView extends View {

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private Path path;

    public TuYaView(Context context) {
        super(context);
        init(context);
    }

    public TuYaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TuYaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    //初始化画比笔   路径
    private void init(Context context) {
        //创建路径
        path = new Path();
        //path.moveTo();//起始的坐标点
        //path.lineTo();//终止的坐标点
        paint = new Paint();//创建画笔
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.STROKE);//空心
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置画布

        bitmap = Bitmap.createBitmap(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec), Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        //将bitmap放到画布上
        canvas.drawBitmap(bitmap,0,0,null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://手指按下事件
                path.moveTo(event.getX(),event.getY());//起始位置
                break;
            case MotionEvent.ACTION_MOVE://手指移动事件
                path.lineTo(event.getX(),event.getY());//终止坐标点
                break;
        }
        canvas.drawPath(path,paint);
        //要不断的去刷新视图
        invalidate();//调用这个方法会不断的去走onDraw方法  在主线程中进行刷新
        postInvalidate();//也是刷新   在子线程中刷新
        return true;
    }

    //设置画笔颜色
    public void setColor(int red) {
        //重置路径---》不然之前画的都变成red了
        path.reset();
        //设置画笔颜色
        paint.setColor(red);
    }
}
