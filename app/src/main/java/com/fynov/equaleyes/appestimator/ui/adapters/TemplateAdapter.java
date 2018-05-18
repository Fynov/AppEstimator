package com.fynov.equaleyes.appestimator.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TemplateAdapter extends RecyclerView.Adapter<TemplateViewHolder>{

    private ArrayList<Template> mArrayList;
    private LayoutInflater inflater;
    Callback callback;
    Context context;

    public TemplateAdapter(ArrayList<Template> templates, Context context){
        this.context = context;
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
        //int test = context.getResources().getIdentifier("drawable/" + temp.getImageUrl(), null, context.getPackageName());
        Picasso.get().load(temp.getImageUrl()).into(holder.imgView);
        //holder.imgView.setImageResource(test);
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
