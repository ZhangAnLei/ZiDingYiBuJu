package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
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
public class GuaGuaLeView extends View {

    private Paint paint,paint2;
    private Bitmap bitmap;
    private Canvas canvas;
    private Path path;

    public GuaGuaLeView(Context context) {
        super(context);
        init(context);
    }

    public GuaGuaLeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //初始化画笔  路径
    private void init(Context context) {

        paint = new Paint();
        path = new Path();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setStrokeWidth(10);
        paint.setTextAlign(Paint.Align.CENTER);
        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(10);
        //设置空心
        paint2.setStyle(Paint.Style.STROKE);
        //设置透明度
        paint2.setAlpha(0);
        //通过画笔来设置一个过度模式   不然没显示
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasText(canvas);
        canvas.drawBitmap(bitmap,0,0,null);
    }

    //绘制中奖信息
    private void canvasText(Canvas canvas) {
        canvas.drawText("恭喜你种了一等奖",getRight()/2,getBottom()/2,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        bitmap = Bitmap.createBitmap(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //16进制  Color.parseColor("#999999")
        canvas.drawColor(Color.BLACK);

    }
    //监听手势

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                break;
        }
        canvas.drawPath(path,paint2);
        invalidate();//刷新
        return true;
    }
}
