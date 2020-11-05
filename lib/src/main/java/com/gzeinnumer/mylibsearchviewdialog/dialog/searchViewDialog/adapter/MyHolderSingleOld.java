package com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialog.adapter;


import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gzeinnumer.mylibsearchviewdialog.R;
import com.gzeinnumer.mylibsearchviewdialog.constant.SelectType;
import com.gzeinnumer.mylibsearchviewdialog.model.SearchViewModel;

public class MyHolderSingleOld extends RecyclerView.ViewHolder {

    public static final int MULTI_SELECTION = 2;
    public static final int SINGLE_SELECTION = 1;
    CheckedTextView textView;
    SearchViewModel mItem;
    LinearLayout parent;
    OnItemSelectedListener itemSelectedListener;

    public MyHolderSingleOld(@NonNull View view, OnItemSelectedListener listener) {
        super(view);
        itemSelectedListener = listener;

        textView = view.findViewById(R.id.checked_text_item);
        parent = view.findViewById(R.id.parent);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItem.isChecked() && getItemViewType() == MULTI_SELECTION) {
                    setChecked(false);
                } else {
                    setChecked(true);
                }
                itemSelectedListener.onItemSelected(mItem);
            }
        });
    }

    public void setChecked(boolean value) {
        if (value) {
            textView.setBackgroundColor(Color.LTGRAY);
        } else {
            textView.setBackground(null);
        }
        mItem.setChecked(value);
        textView.setChecked(value);
    }

    public void bind(int TYPE, SearchViewModel data) {

        if (RvItemAdapterOld.textColor != -100)
            textView.setTextColor(RvItemAdapterOld.textColor);

        if (RvItemAdapterOld.textSize != -100)
            textView.setTextSize((float) RvItemAdapterOld.textSize);

        textView.setText(String.valueOf(data.getName()));
        TypedValue value = new TypedValue();

        if (TYPE != SelectType.TYPE_SINGLE) {
            textView.getContext().getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorMultiple, value, true);
        } else {
            textView.getContext().getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorSingle, value, true);
        }
        int checkMarkDrawableResId = value.resourceId;
        textView.setCheckMarkDrawable(checkMarkDrawableResId);

        mItem = data;
        setChecked(mItem.isChecked());
    }

    public interface OnItemSelectedListener {
        void onItemSelected(SearchViewModel item);
    }
}
