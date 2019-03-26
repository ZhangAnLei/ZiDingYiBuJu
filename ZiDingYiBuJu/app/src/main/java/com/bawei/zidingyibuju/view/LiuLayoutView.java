package com.bawei.zidingyibuju.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.zidingyibuju.R;

import java.util.ArrayList;

/**
 * @Author：张安磊
 * @E-mail：
 * @Date：
 * @Description：描述信息
 */
public class LiuLayoutView extends RelativeLayout {

    private LinearLayout layout_all;
    private TextView text_view;
    private Context context;
    private View view;
    private LinearLayout view_h;

    public LiuLayoutView(Context context) {
        super(context);
        init(context);
    }

    public LiuLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context=context;
        //第一步：创建一个垂直的layout
        view = View.inflate(context, R.layout.layout_v, null);
        layout_all =(LinearLayout) view.findViewById(R.id.layout_all);
        //第二步:创建一个水平的layout
        view_h = (LinearLayout) View.inflate(context, R.layout.layout_h, null);

        layout_all.addView(view_h);
        addView(view);
    }
    //传递数据
    private ArrayList<String> mList=new ArrayList<>();
    public void setList(ArrayList<String > list){
        mList=list;
        view_h.removeAllViews();
        int len=0;
        layout_all.removeAllViews();

        for (int i=0;i<list.size();i++){

            //换行
            String data = list.get(i);
            len+=data.length();
            if (len>26){
                //换行
                //重新创建一个横向的布局
                view_h = (LinearLayout) View.inflate(context, R.layout.layout_h, null);

                layout_all.addView(view_h);
                len=0;
            }


            //第三步：创建展示数据的view
            View view_text = View.inflate(context, R.layout.layout_text, null);
            text_view =(TextView)view_text.findViewById(R.id.text_view);
            text_view.setText(list.get(i));
            view_h.addView(view_text);
            LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) text_view.getLayoutParams();
            params.leftMargin=10;
            params.topMargin=10;
            params.weight=1;
            text_view.setLayoutParams(params);
    }
    }
}
