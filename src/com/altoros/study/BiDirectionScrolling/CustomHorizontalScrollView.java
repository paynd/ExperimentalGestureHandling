package com.altoros.study.BiDirectionScrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Here we intercept horizontal gesture.
 */
public class CustomHorizontalScrollView extends HorizontalScrollView {
    private GestureDetector mGestureDetector;

    public CustomHorizontalScrollView(Context context) {
        super(context);
        mGestureDetector = new GestureDetector(context, new XScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context, new XScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mGestureDetector = new GestureDetector(context, new XScrollDetector());
        setFadingEdgeLength(10);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mGestureDetector.onTouchEvent(ev) && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event) && super.onTouchEvent(event);
    }

    class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceX) > Math.abs(distanceY)) {
                return true;
            }
            return false;
        }
    }
}
