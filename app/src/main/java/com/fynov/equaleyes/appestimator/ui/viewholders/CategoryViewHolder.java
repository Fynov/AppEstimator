package com.fynov.equaleyes.appestimator.ui.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.databinding.ItemCategoryBinding;
import com.fynov.equaleyes.appestimator.ui.adapters.FeatureAdapter;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private ItemCategoryBinding mBinding;
    FeatureAdapter mAdapter;
    public CategoryViewHolder(ItemCategoryBinding binding) {
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

        mAdapter = new FeatureAdapter(category.getFeatures());
        mBinding.rvFeatures.setLayoutManager(new LinearLayoutManager(mBinding.getRoot().getContext()));
        mBinding.rvFeatures.setAdapter(mAdapter);
    }
}
