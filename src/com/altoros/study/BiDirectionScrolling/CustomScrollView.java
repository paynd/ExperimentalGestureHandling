package com.altoros.study.BiDirectionScrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Here we intercept vertical gesture.
 */
public class CustomScrollView extends ScrollView {

    private GestureDetector mGestureDetector;

    public CustomScrollView(Context context) {
        super(context);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(10);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event) && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event) && super.onTouchEvent(event);
    }

    // Return false if we're scrolling in the x direction
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceY) > Math.abs(distanceX)) {
                return true;
            }
            return false;
        }
    }
}

