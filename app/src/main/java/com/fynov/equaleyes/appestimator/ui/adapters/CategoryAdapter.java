package com.fynov.equaleyes.appestimator.ui.adapters;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fynov.equaleyes.appestimator.R;

import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.databinding.ItemCategoryBinding;
import com.fynov.equaleyes.appestimator.ui.viewholders.CategoryViewHolder;
import com.fynov.equaleyes.appestimator.utils.Callback;

import java.util.ArrayList;

/**
 * Created by Fynov on 12/03/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    private ArrayList<Category> mArrayList;
    private Callback categoryCallback;

    public CategoryAdapter(ArrayList<Category> categories, Callback categoryCallback) {
        mArrayList = categories;
        this.categoryCallback = categoryCallback;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCategoryBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_category, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        //final Currency trenutni = all.getCurrency(position);
        Category category = mArrayList.get(position);
        holder.bind(category, categoryCallback);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public void setItems(ArrayList<Category> categories){
        mArrayList = categories;
        notifyDataSetChanged();
    }
}



