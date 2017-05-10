package com.example.lenovo.tj.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.tj.R;

import static android.R.attr.text;
import static android.R.attr.width;

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
    private int mTextAttr = Color.BLUE;
    private String mText;

    public MyPandaCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyPandaCircle(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.szm);
        mText = ta.getString(R.styleable.szm_mtext);
        mTextAttr = ta.getColor(R.styleable.szm_mColor, Color.BLUE);

        ta.recycle();

        //Toast.makeText(context, mText +""+ mTextAttr,Toast.LENGTH_SHORT).show();

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
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        //设置画笔的样式
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLACK);
        int radiusBig = 200;

        canvas.drawCircle(currentX,currentY,radiusBig+padding,mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawArc(new RectF(currentX - radiusBig, currentY - radiusBig, currentX + radiusBig, currentY + radiusBig), 90, 180, true, mPaint);

        RectF rectF = new RectF(currentX-radiusBig/2,currentY-radiusBig,currentX+radiusBig/2,currentY);
        canvas.drawArc(rectF,269,182,true,mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawArc(new RectF(currentX-radiusBig/2,currentY,currentX+radiusBig/2,currentY+radiusBig),89,182,true,mPaint);

        canvas.drawCircle(currentX,currentY-radiusBig/2,radiusBig/6,mPaint);

        mPaint.setColor(mTextAttr);
        canvas.drawCircle(currentX,currentY+radiusBig/2,radiusBig/6,mPaint);

        canvas.drawText(mText,200,200,mPaint);


    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();//获取当前手指所在x轴
        currentY = event.getY();//获取当前手指所在y轴
        invalidate();//立刻重绘
        return true;//返回true表示不通知父控件处理，自己处理
    }*/
}
