package com.fynov.equaleyes.appestimator.ui.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.data.models.Template;
import com.fynov.equaleyes.appestimator.databinding.ActivityMainBinding;
import com.fynov.equaleyes.appestimator.databinding.ItemCategoryBinding;
import com.fynov.equaleyes.appestimator.databinding.ItemTemplateBinding;
import com.fynov.equaleyes.appestimator.ui.activities.ActivityEstimator;
import com.fynov.equaleyes.appestimator.ui.adapters.FeatureAdapter;
import com.fynov.equaleyes.appestimator.utils.Callback;

public class TemplateViewHolder extends RecyclerView.ViewHolder {

    public TextView texView;
    public ImageView imgView;
    private ItemTemplateBinding mBinding;

    public TemplateViewHolder(ItemTemplateBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
        imgView = binding.imageUrl;
    }

    public void bind(@NonNull final Template template, final Context context) {
        mBinding.setUrl(template);
        mBinding.executePendingBindings();
        mBinding.constraintlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityEstimator.class);
                intent.putExtra("template_name", template.getName());
                context.startActivity(intent);
            }
        });
    }
}



