package com.fynov.equaleyes.appestimator.ui.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.databinding.ItemCategoryBinding;
import com.fynov.equaleyes.appestimator.ui.activities.ActivityEstimator;
import com.fynov.equaleyes.appestimator.ui.activities.ActivitySummary;
import com.fynov.equaleyes.appestimator.ui.adapters.FeatureAdapter;
import com.fynov.equaleyes.appestimator.utils.Callback;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private ItemCategoryBinding mBinding;
    private FeatureAdapter mAdapter;
    public CategoryViewHolder(ItemCategoryBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(@NonNull final Category category, final Callback categoryCallback, final Context context) {
        Callback callback = new Callback() {
            @Override
            public void onFeatureSelectionChanged() {
                updateView(category);
                categoryCallback.onFeatureSelectionChanged();
            }
        };

        updateView(category);
        mBinding.executePendingBindings();

        mAdapter = new FeatureAdapter(category.getFeatures(), callback);
        mBinding.rvFeatures.setLayoutManager(new LinearLayoutManager(mBinding.getRoot().getContext()));
        mBinding.rvFeatures.setAdapter(mAdapter);

        mBinding.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBinding.rvFeatures.getVisibility() == View.VISIBLE)
                    mBinding.rvFeatures.setVisibility(View.GONE);
                else
                    mBinding.rvFeatures.setVisibility(View.VISIBLE);

                Intent intent = new Intent(context, ActivitySummary.class);
                intent.putExtra("category_name", category.getName());
                context.startActivity(intent);
            }
        });
    }

    private void updateView(Category category){
        Double sum = 0.0;
        boolean selected = false;
        for (Feature feat: category.getFeatures()) {
            if (feat.isSelected()){
                sum += feat.getTime();
                selected = true;
            }
        }
        mBinding.ivAddCategory.setSelected(selected);
        category.setTime(sum);
        mBinding.setCategory(category);
    }
}
