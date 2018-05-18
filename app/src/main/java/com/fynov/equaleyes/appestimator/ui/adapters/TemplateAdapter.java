package com.fynov.equaleyes.appestimator.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Template;
import com.fynov.equaleyes.appestimator.databinding.ActivityMainBinding;
import com.fynov.equaleyes.appestimator.databinding.ItemCategoryBinding;
import com.fynov.equaleyes.appestimator.databinding.ItemTemplateBinding;
import com.fynov.equaleyes.appestimator.ui.viewholders.CategoryViewHolder;
import com.fynov.equaleyes.appestimator.ui.viewholders.TemplateViewHolder;
import com.fynov.equaleyes.appestimator.utils.Callback;

import java.util.ArrayList;

public class TemplateAdapter extends RecyclerView.Adapter<TemplateViewHolder>{

    private ArrayList<Template> mArrayList;
    private LayoutInflater inflater;
    Callback callback;

    public TemplateAdapter(ArrayList<Template> templates, Context context){
        mArrayList = templates;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public TemplateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTemplateBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_template, parent, false);
        TemplateViewHolder holder = new TemplateViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(TemplateViewHolder holder, int position) {
        Template temp = mArrayList.get(position);
        holder.texView.setText(temp.getImageUrl());
        holder.bind(temp);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public void setItems(ArrayList<Template> templates){
        mArrayList = templates;
        notifyDataSetChanged();
    }
}
