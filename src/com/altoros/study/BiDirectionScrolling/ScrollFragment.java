package com.altoros.study.BiDirectionScrolling;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScrollFragment extends Fragment {
    private LinearLayout mContainerView;

    LinearLayout.LayoutParams fillLayoutParams = new LinearLayout.LayoutParams(
            (LinearLayout.LayoutParams.MATCH_PARENT), (ViewGroup.LayoutParams.MATCH_PARENT));

    LinearLayout.LayoutParams dp60LayoutParams = new LinearLayout.LayoutParams(
            200, 200);

    LinearLayout.LayoutParams categoriesTextViewLayoutParams = new LinearLayout.LayoutParams(
            (LinearLayout.LayoutParams.WRAP_CONTENT), (ViewGroup.LayoutParams.WRAP_CONTENT));

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

        LinearLayout rowContainer = (LinearLayout) getView().findViewById(R.id.container_main_discounts);

        TextView categoryTextView = new TextView(context);
        categoryTextView.setText("CategoryText");
        categoriesTextViewLayoutParams.setMargins(5, 5, 5, 5);
        categoryTextView.setLayoutParams(categoriesTextViewLayoutParams);

        rowContainer.addView(categoryTextView);

        CustomHorizontalScrollView customHorizontalScrollView = new CustomHorizontalScrollView(context);

        customHorizontalScrollView.setLayoutParams(fillLayoutParams);

        LinearLayout horizontal = new LinearLayout(context);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);
        horizontal.setLayoutParams(fillLayoutParams);


        for (int j = 0; j < 4; j++) {
            addProviderBanner(horizontal);
        }

        customHorizontalScrollView.addView(horizontal);

        rowContainer.addView(customHorizontalScrollView, i, fillLayoutParams);
    }

    private void addProviderBanner(ViewGroup container) {
        Context context = getActivity();

        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(getResources().getColor(R.color.blue));
        dp60LayoutParams.setMargins(2, 2, 15, 2);
        imageView.setLayoutParams(dp60LayoutParams);

        container.addView(imageView);
    }

    private void addProviderPremiumBanner(ViewGroup container) {
        Context context = getActivity();

        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(getResources().getColor(R.color.blue));
        dp60LayoutParams.setMargins(2, 2, 15, 2);
        imageView.setLayoutParams(dp60LayoutParams);

        container.addView(imageView);
    }

}
