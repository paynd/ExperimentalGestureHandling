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
            300, 150);

    LinearLayout.LayoutParams endSquareLayoutParams = new LinearLayout.LayoutParams(
            150, 150);

    LinearLayout.LayoutParams categoriesTextViewLayoutParams = new LinearLayout.LayoutParams(
            (LinearLayout.LayoutParams.WRAP_CONTENT), (ViewGroup.LayoutParams.WRAP_CONTENT));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_layout_manual, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inflateRow();
        inflateRow();
        inflateRow();
        inflateRow();
        inflateRow();
        inflateRow();
        inflateRow();
    }

    private void inflateRow() {
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


        for (int j = 0; j < 7; j++) {
            addProviderBanner(horizontal);
        }

        addCategoryEndBanner(horizontal);

        customHorizontalScrollView.addView(horizontal);

        rowContainer.addView(customHorizontalScrollView, fillLayoutParams);
    }

    private void addProviderBanner(ViewGroup container) {
        Context context = getActivity();

        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(getResources().getColor(R.color.blue));
        dp60LayoutParams.setMargins(2, 2, 15, 2);
        imageView.setLayoutParams(dp60LayoutParams);

        container.addView(imageView);
    }

    private void addCategoryEndBanner(ViewGroup container) {
        Context context = getActivity();

        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(getResources().getColor(R.color.blue));
        endSquareLayoutParams.setMargins(2, 2, 15, 2);
        imageView.setLayoutParams(endSquareLayoutParams);

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
