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
import com.fynov.equaleyes.appestimator.ui.viewholders.FeatureViewHolder;

import java.util.ArrayList;

/**
 * Created by Fynov on 12/03/17.
 */

public class FeatureAdapter extends RecyclerView.Adapter<FeatureViewHolder>{
    public ArrayList<Feature> mArrayList;

    public FeatureAdapter(ArrayList<Feature> features) {
        mArrayList = features;
    }

    @Override
    public FeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFeatureBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_feature, parent, false);
        return new FeatureViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(FeatureViewHolder holder, int position) {
        Feature feature = mArrayList.get(position);
        holder.bind(feature);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}



