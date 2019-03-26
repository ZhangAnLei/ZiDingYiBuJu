package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：描述信息
 */
public class WaterView extends View {

    private Paint paint;
    private Path path;
    private float mX;
    private AnimatorListener animatorListener;

    public WaterView(Context context) {
        super(context);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //初始化 路径 画笔
    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        //初始化路径
        path = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //重置路径
        path.reset();
        //记录起始位置
        path.moveTo(getLeft(),getBottom());

        //记录波动的位置   PI==π
        float mPi = (float) (Math.PI * 2 / getRight());//每一份所占的度数 i=

        mX += 0.1f;
        for (int i=0;i<=getRight();i+=20){
            //path.lineTo(i, (float) Math.cos(mPi*i- mX)*10);
            float y = (float) Math.cos(mPi * i - mX) * 10;
            path.lineTo(i,y);
            //接口传值
            if (animatorListener!=null){
                animatorListener.Animator(y);
            }
        }

        //记录结束位置
        path.lineTo(getRight(),getBottom());

        canvas.drawPath(path,paint);

        //要不断的去执行
        postInvalidateDelayed(20);//不仅执行了，还刷新了视图

    }

    public void setAnimatorListener(AnimatorListener animatorListener){
        this.animatorListener=animatorListener;
    }

    public interface AnimatorListener{
        void Animator(float y);
    }
}
