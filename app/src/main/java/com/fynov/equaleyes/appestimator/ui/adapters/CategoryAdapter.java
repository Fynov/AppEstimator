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

import java.util.ArrayList;

/**
 * Created by Fynov on 12/03/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    FeatureAdapter mAdapter;
    Activity ac;
    public ArrayList<Category> mArrayList;


    public CategoryAdapter(ArrayList<Category> categories, Activity ac) {
        this.ac = ac;
        mArrayList = categories;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding mBinding;
        public ViewHolder(ItemCategoryBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(@NonNull Category category) {

            int sum = 0;
            for (Feature feat: category.getFeatures()) {
                if (feat.getSelected())
                    sum += feat.getTime();
            }
            category.setTime(sum);

            mBinding.setCategory(category);
            mBinding.executePendingBindings();

            mAdapter = new FeatureAdapter(category.getFeatures(), ac);
            mBinding.rvFeatures.setLayoutManager(new LinearLayoutManager(ac));
            mBinding.rvFeatures.setAdapter(mAdapter);
        }
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCategoryBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_category, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //final Currency trenutni = all.getCurrency(position);
        Category category = mArrayList.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}



