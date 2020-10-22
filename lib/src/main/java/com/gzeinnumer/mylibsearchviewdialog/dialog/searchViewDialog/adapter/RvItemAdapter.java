package com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gzeinnumer.mylibsearchviewdialog.R;
import com.gzeinnumer.mylibsearchviewdialog.constant.SelectType;
import com.gzeinnumer.mylibsearchviewdialog.model.SearchViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RvItemAdapter extends RecyclerView.Adapter implements Filterable, MyHolderSingle.OnItemSelectedListener {

    int TYPE;
    public ArrayList<SearchViewModel> list;
    public ArrayList<SearchViewModel> listFilter;
    MyHolderSingle.OnItemSelectedListener listener;

    public static int textColor = -100;
    public static int textSize = -100;

    public RvItemAdapter(int type, MyHolderSingle.OnItemSelectedListener listener,
                          List<SearchViewModel> items) {
        this.TYPE = type;
        this.listener = listener;

        list = new ArrayList<>();
        for (SearchViewModel item : items) {
            list.add(new SearchViewModel(item.getPosition(),item.getName(), false));
        }
        listFilter = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyHolderSingle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_single, parent, false);
        return new MyHolderSingle(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((MyHolderSingle) viewHolder).bind(TYPE,list.get(position));
    }

    public List<SearchViewModel> getSelectedItems() {

        List<SearchViewModel> selectedItems = new ArrayList<>();
        for (SearchViewModel item : list) {
            if (item.isChecked()) {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(TYPE != SelectType.TYPE_SINGLE){
            return MyHolderSingle.MULTI_SELECTION;
        }
        else{
            return MyHolderSingle.SINGLE_SELECTION;
        }
    }

    @Override
    public void onItemSelected(SearchViewModel item) {
        if (TYPE == SelectType.TYPE_SINGLE) {
            for (SearchViewModel selectableItem : list) {
                if (!selectableItem.equals(item)
                        && selectableItem.isChecked()) {
                    selectableItem.setChecked(false);
                } else if (selectableItem.equals(item)
                        && item.isChecked()) {
                    selectableItem.setChecked(true);
                }
            }
            notifyDataSetChanged();
        }
        listener.onItemSelected(item);
    }

    public void setTextItemColor(int textListColor) {
        textColor = textListColor;
    }

    public void setTextItemSize(int textListSize) {
        textSize = textListSize;
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private final Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SearchViewModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                Collections.sort(listFilter, new Comparator<SearchViewModel>() {
                    @Override
                    public int compare(SearchViewModel o1, SearchViewModel o2) {
                        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                    }
                });
                filteredList.addAll(listFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (SearchViewModel item : listFilter) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
