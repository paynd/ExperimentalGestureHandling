package com.altoros.study.BiDirectionScrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Here we intercept vertical gesture.
 */
public class CustomScrollView extends ScrollView {
   private static final String TAG = "CustomScrollView";
    private GestureDetector mGestureDetector;

    public CustomScrollView(Context context) {
        super(context);
        Log.d(TAG, "constructor 1");
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "constructor 2");
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(10);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.d(TAG, "constructor 3");
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(10);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.d(TAG, "onInterceptTouchEvent. ME, action:" + event.getAction());
        return super.onInterceptTouchEvent(event) && mGestureDetector.onTouchEvent(event);
    }

    // Return false if we're scrolling in the x direction
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceY) > Math.abs(distanceX)) {
                Log.d(TAG, "YScrollDetector. y>x");
                return true;
            }
            Log.d(TAG, "YScrollDetector. x>y");
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }
    }
}

