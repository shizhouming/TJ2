package com.example.lenovo.tj.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * date: 2017/5/8
 * author: 史洲铭(lenovo)
 * function:
 */

public class MyPandaCircle extends View {

    private Paint mPaint;
    private int padding = 8;
    private float currentX = 0;
    private float currentY = 0;

    public MyPandaCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public MyPandaCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPandaCircle(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        currentX = MeasureSpec.getSize(widthMeasureSpec) / 2;//通过MeasureSpec拿到X轴
        currentY = MeasureSpec.getSize(heightMeasureSpec) / 2;//通过MeasureSpec拿到Y轴
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);//测绘
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //设置画笔的样式
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);

        int width = getWidth()/2;
        int height = getHeight()/2;
        int radiusBig = width;

        canvas.drawCircle(currentX,currentY,radiusBig,mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawArc(new RectF(currentX - radiusBig, currentY - radiusBig, currentX + radiusBig, currentY + radiusBig), 90, 180, true, mPaint);

        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
