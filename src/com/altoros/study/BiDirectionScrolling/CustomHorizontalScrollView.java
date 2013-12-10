package com.altoros.study.BiDirectionScrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Here we intercept horizontal gesture.
 */
public class CustomHorizontalScrollView extends HorizontalScrollView {
    private static final String TAG = "CustomHorizontalScrollView";
    private GestureDetector mGestureDetector;

    public CustomHorizontalScrollView(Context context) {
        super(context);
        Log.d(TAG, "constructor 1");
        mGestureDetector = new GestureDetector(context, new XScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "constructor 2");
        mGestureDetector = new GestureDetector(context, new XScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.d(TAG, "constructor 3");
        mGestureDetector = new GestureDetector(context, new XScrollDetector());
        setFadingEdgeLength(10);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.d(TAG, "onInterceptTouchEvent. ME, action:" + event.getAction());
        return super.onInterceptTouchEvent(event) && mGestureDetector.onTouchEvent(event);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.d(TAG, "onTouchEvent. ME, action:" + event.getAction());
//        return super.onTouchEvent(event) && mGestureDetector.onTouchEvent(event);
//    }

    class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceX) > Math.abs(distanceY)) {
                Log.d(TAG, "XScrollDetector. x>y");
                return true;
            }
            Log.d(TAG, "XScrollDetector. y>x");
            return false;
        }
    }
}
