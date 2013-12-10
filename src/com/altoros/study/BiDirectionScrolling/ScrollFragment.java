package com.altoros.study.BiDirectionScrolling;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ScrollFragment extends Fragment {
    private LinearLayout mContainerView;

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_layout_manual, null);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inflateRow(0);
        inflateRow(1);
        inflateRow(2);
    }

    private void inflateRow(int i) {
        Context context = getActivity();

        LinearLayout.LayoutParams wrapLayoutParams = new LinearLayout.LayoutParams(
                (LinearLayout.LayoutParams.WRAP_CONTENT), (ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout.LayoutParams fillLayoutParams = new LinearLayout.LayoutParams(
                (LinearLayout.LayoutParams.MATCH_PARENT), (ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout.LayoutParams dp60LayoutParams = new LinearLayout.LayoutParams(
                200, 200);

        LinearLayout rowContainer = (LinearLayout) getView().findViewById(R.id.container_main_discounts);

        CustomHorizontalScrollView customHorizontalScrollView = new CustomHorizontalScrollView(context);

        customHorizontalScrollView.setLayoutParams(fillLayoutParams);

        LinearLayout horizontal = new LinearLayout(context);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);
        horizontal.setLayoutParams(fillLayoutParams);

        ImageView imageView1 = new ImageView(context);
        ImageView imageView2 = new ImageView(context);
        ImageView imageView3 = new ImageView(context);
        ImageView imageView4 = new ImageView(context);

        imageView1.setBackgroundColor(getResources().getColor(R.color.blue));
        imageView2.setBackgroundColor(getResources().getColor(R.color.red));
        imageView3.setBackgroundColor(getResources().getColor(R.color.brown));
        imageView4.setBackgroundColor(getResources().getColor(R.color.green));

        imageView1.setLayoutParams(dp60LayoutParams);
        imageView2.setLayoutParams(dp60LayoutParams);
        imageView3.setLayoutParams(dp60LayoutParams);
        imageView4.setLayoutParams(dp60LayoutParams);

        horizontal.addView(imageView1);
        horizontal.addView(imageView2);
        horizontal.addView(imageView3);
        horizontal.addView(imageView4);

        customHorizontalScrollView.addView(horizontal);

        rowContainer.addView(customHorizontalScrollView, i, fillLayoutParams);
    }
}
