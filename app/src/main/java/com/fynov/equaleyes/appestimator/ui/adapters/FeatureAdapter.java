package com.fynov.equaleyes.appestimator.ui.adapters;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.databinding.ItemFeatureBinding;

import java.util.ArrayList;

/**
 * Created by Fynov on 12/03/17.
 */

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder>{
    Activity ac;
    public ArrayList<Feature> mArrayList;


    public FeatureAdapter(ArrayList<Feature> features, Activity ac) {
        this.ac = ac;
        mArrayList = features;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemFeatureBinding mBinding;
        public ViewHolder(ItemFeatureBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(@NonNull final Feature feature) {
            mBinding.setFeature(feature);
            mBinding.executePendingBindings();
            if (feature.getSelected())
                mBinding.ivAddFeature.setImageDrawable(ResourcesCompat.getDrawable(ac.getResources(), R.drawable.ic_checkbox_selected_blue, null));
            else
                mBinding.ivAddFeature.setImageDrawable(ResourcesCompat.getDrawable(ac.getResources(), R.drawable.ic_checkbox_unselected_blue, null));

            mBinding.ivAddFeature.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (feature.getSelected()){
                        feature.setSelected(false);
                        mBinding.ivAddFeature.setImageDrawable(ResourcesCompat.getDrawable(ac.getResources(), R.drawable.ic_checkbox_unselected_blue, null));
                    }else {
                        feature.setSelected(true);
                        mBinding.ivAddFeature.setImageDrawable(ResourcesCompat.getDrawable(ac.getResources(), R.drawable.ic_checkbox_selected_blue, null));
                    }
                }
            });
        }
    }

    @Override
    public FeatureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFeatureBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_feature, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feature feature = mArrayList.get(position);
        holder.bind(feature);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}



