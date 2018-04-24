package com.fynov.equaleyes.appestimator;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.fynov.equaleyes.lib_data.Answer;
import com.fynov.equaleyes.lib_data.Question;

import java.util.ArrayList;

/**
 * Created by Fynov on 12/03/17.
 */

class AdapterAnswer extends RecyclerView.Adapter<AdapterAnswer.ViewHolder>{
    Activity ac;

    public ArrayList<Answer> mArrayList;


    public AdapterAnswer(Question question, Activity ac) {
        this.ac = ac;
        mArrayList = question.getAnswers();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvAnswer;
        public TextView tvDetails;
        public CheckBox cbAnswer;
        public ConstraintLayout ly;
        public ImageView ivArrow;


        public ViewHolder(View v) {
            super(v);
            ly = v.findViewById(R.id.linearLayout);
            tvAnswer = v.findViewById(R.id.tvAnswer);
            tvDetails = v.findViewById(R.id.tvDetails);
            cbAnswer =  v.findViewById(R.id.cbAnswer);
            ivArrow = v.findViewById(R.id.ivArrow);

        }
    }

    private static void startDView(String currencyID, Activity ac) {
        //  System.out.println(name+":"+position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //final Currency trenutni = all.getCurrency(position);
        final Answer trenutni = mArrayList.get(position);
        final String text = trenutni.text;
        final String details = trenutni.details;


        holder.tvAnswer.setText(text);
        holder.tvDetails.setText(details);



        holder.ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvDetails.getVisibility() == View.VISIBLE){
                    holder.tvDetails.setVisibility(View.GONE);
                    holder.ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_32dp);
                }
                else {
                    holder.tvDetails.setVisibility(View.VISIBLE);
                    holder.ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_32dp);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

}


