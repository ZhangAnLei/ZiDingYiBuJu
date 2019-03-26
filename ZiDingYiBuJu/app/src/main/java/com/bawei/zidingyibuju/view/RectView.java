package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：描述信息
 */
public class RectView extends View {

    private Paint paint,paint1,paint2;
    private String[] str={
            "管理成本","劳务成本","销售成本","资产盘亏"
    };
    private String[] str1={
            "30.00%","25.00%","20.00%","15.00%","10.00%","5.00%","0.00%"
    };
    private float[] str2={
           27.64f,28.17f,21.48f,22.70f
    };
    private String[] str3={
            "27.64%",
            "28.17%",
            "21.48%",
            "22.70%"
    };

    public RectView(Context context) {
        super(context);
        init(context);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.parseColor("#999999"));
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);//空心
        paint.setTextSize(50);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);

        paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);
        paint1.setTextAlign(Paint.Align.CENTER);
        paint1.setTextSize(16);
        paint1.setStrokeWidth(1);

        paint2 = new Paint();
        paint2.setColor(Color.WHITE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文字
        canvasTitle(canvas);
        //绘制XY轴
        canvasXY(canvas);
    }

    private float marginLeft=100;
    private void canvasXY(Canvas canvas) {
        canvas.drawLine(marginLeft,getBottom()-marginLeft*2,getRight()-marginLeft,getBottom()-marginLeft*2,paint1);//X轴
        canvas.drawLine(marginLeft,marginLeft*2,marginLeft,getBottom()-marginLeft*2,paint1);//Y轴
        //绘制X轴的份数
        float fenshuX = (getRight() - marginLeft * 2) / 4;
        for (int i=0;i<5;i++){
            canvas.drawLine(marginLeft+(fenshuX*i),getBottom()-marginLeft*2,marginLeft+(fenshuX*i),getBottom()-marginLeft*2+10,paint1);
        }
        //绘制文字
        for (int i=0;i<4;i++){
            canvas.drawText(str[i],marginLeft+(fenshuX/2+(fenshuX*i)),getBottom()-marginLeft*2+20,paint1);
        }

        //绘制Y轴
        float fenshuY = (getBottom() - marginLeft * 4) / 6;
        //canvas.drawLine(marginLeft, marginLeft * 2 + fenshuY, marginLeft-10 , marginLeft * 2 + fenshuY, paint1);
        for (int i=0;i<7;i++) {
            canvas.drawLine(marginLeft-10, marginLeft * 2 + (fenshuY * i), marginLeft , marginLeft * 2 + (fenshuY * i), paint1);
        }
        for (int i=0;i<7;i++){
            canvas.drawText(str1[i],marginLeft-40, marginLeft * 2 + (fenshuY * i)+5,paint1);
        }
        float Y = (getBottom() - (marginLeft * 4)) / 30;

        //绘制柱形图
        for (int i=0;i<4;i++){
            float h = str2[i] * Y;
            canvas.drawLine(marginLeft+fenshuX/2+(fenshuX*i),getBottom()-marginLeft*2,marginLeft+fenshuX/2+(fenshuX*i),getBottom()-marginLeft*2-h,paint2);
            canvas.drawText(str3[i],marginLeft+fenshuX/2+(fenshuX*i),getBottom()-marginLeft*2-h-20,paint1);
        }


    }

    private void canvasTitle(Canvas canvas) {

        canvas.drawText("成本费用占比",getRight()/2,50,paint);
    }
}
