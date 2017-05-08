package com.example.lenovo.tj.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.lenovo.tj.MainActivity;

import static android.R.attr.width;
import static android.R.attr.x;
import static android.R.attr.y;

/**
 * date: 2017/5/8
 * author: 史洲铭(lenovo)
 * function:
 */

public class MyCircle extends View {

    private Context mContext;
    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private Region mRegion;
    private Region mRegion2;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
         mContext = context;
    }

    public MyCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);

        mWidth = getWidth() / 2;
        mHeight = getHeight() / 2;

        Path path0 = new Path();
        path0.addCircle(mWidth, mHeight, mWidth, Path.Direction.CW);
        canvas.drawPath(path0, mPaint);
        //canvas.drawCircle(mWidth, mHeight, mWidth, mPaint);
        //canvas.drawRect(50, 50, 250, 250, paint);

        mPaint.setColor(Color.GREEN);
        Path path = new Path();
        path.moveTo(mWidth, mHeight - mWidth);
        path.lineTo(mWidth - mWidth, mHeight);
        path.lineTo(mWidth, mHeight + mWidth);
        path.lineTo(mWidth + mWidth, mHeight);
        path.close();
        canvas.drawPath(path, mPaint);

        mPaint.setColor(Color.BLUE);
        Path path2 = new Path();
        path2.moveTo(mWidth - mWidth / 2, mHeight - mWidth / 2);
        path2.lineTo(mWidth - mWidth / 2, mHeight + mWidth / 2);
        path2.lineTo(mWidth + mWidth / 2, mHeight + mWidth / 2);
        path2.lineTo(mWidth + mWidth / 2, mHeight - mWidth / 2);
        path2.close();
        canvas.drawPath(path2, mPaint);

        path0.op(path, Path.Op.DIFFERENCE);
        path.op(path2, Path.Op.DIFFERENCE);

        mRegion = new Region();
        mRegion.setPath(path0,new Region(0,0,1000,1000));
        mRegion2 = new Region();
        mRegion2.setPath(path,new Region(0,0,1000,1000));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int area = 0;

            if (mRegion.contains(x,y)) {
                area = 3;
            } else if (mRegion2.contains(x, y)) {
                area = 2;
            } else {
                area = 1;
            }
            ((MainActivity) mContext).showClickArea(area);
        }
        return super.onTouchEvent(event);
    }

    /* @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
            int area = 0;

            int x1 = (int)x - mWidth;
            int y1 = (int)y - mHeight;

            if (x >= mWidth - mWidth / 2 && x < mWidth + mWidth / 2 && y > mHeight - mWidth / 2
                    && y < mHeight + mWidth / 2) {
                area = 1;
            } else if (mWidth -Math.abs(x1) > Math.abs(y1)) {
                area = 2;
            } else {
                area = 3;
            }
            ((MainActivity) mContext).showClickArea(area);
        }
        return super.onTouchEvent(event);
    }*/


}
