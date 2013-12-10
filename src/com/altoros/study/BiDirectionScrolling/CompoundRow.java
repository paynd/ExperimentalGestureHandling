package com.altoros.study.BiDirectionScrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * User: andrey.kupreychik
 * Date: 12/9/13
 * Time: 4:55 PM
 */
public class CompoundRow extends LinearLayout {


    public CompoundRow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompoundRow(Context context) {
        super(context);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        setId();
        inflater.inflate(R.layout.compound_proviser_row, this, true);

    }



}
