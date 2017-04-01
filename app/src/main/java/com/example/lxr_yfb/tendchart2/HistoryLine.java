package com.example.lxr_yfb.tendchart2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by ${zhangzheng} on 2017/3/18.
 */

public class HistoryLine extends View {
    //获取屏幕宽度
    DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
    int widthPixels = displayMetrics.widthPixels;
    public int XPoint = 40;    //原点的X坐标
    public int YPoint = 260;     //原点的Y坐标
    public String[] YLabel;    //Y的刻度
    public String[] Data;      //数据
    public int Xlength;         //X刻度计算单位
    public int YScale = 40;     //Y的刻度长度
    public int XLength = widthPixels - 200;     //X轴的长度
    private  int xScale;


    public HistoryLine(Context context,int length) {
        super(context);
        Xlength = length;
        //X的刻度长度
        xScale = (widthPixels - 160) / Xlength;
    }



    public void SetInfo(String[] YLabels, String[] AllData) {

        //Y轴刻度
        YLabel = YLabels;
        //数据
        Data = AllData;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);//重写onDraw方法

        //canvas.drawColor(Color.WHITE);//设置背景颜色
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);//去锯齿
        paint.setColor(Color.BLUE);//颜色


        //设置X轴
        canvas.drawLine(XPoint, YPoint, XPoint + XLength, YPoint, paint);   //轴线
        for (int i = 0; i < Xlength; i++) {

            try {
                //X轴坐标
                canvas.drawText(i + 1 + "", i * xScale + XPoint, YPoint + 30, paint);

                //数据值
                if (i > 0 && YCoord(Data[i - 1]) != -999 && YCoord(Data[i]) != -999)  //保证有效数据
                    canvas.drawLine(XPoint + (i - 1) * xScale, YCoord(Data[i - 1]), XPoint + i * xScale, YCoord(Data[i]), paint);
                canvas.drawCircle(XPoint + i * xScale, YCoord(Data[i]), 2, paint);
            } catch (Exception e) {
            }
        }

        paint.setTextSize(16);

    }

    private int YCoord(String y0)  //计算绘制时的Y坐标，无数据时返回-999
    {
        int y;
        try {
            y = Integer.parseInt(y0);
        } catch (Exception e) {
            return -999;    //出错则返回-999
        }
        try {
            return YPoint - y * YScale / Integer.parseInt(YLabel[1]);
        } catch (Exception e) {
        }
        return y;
    }

}
