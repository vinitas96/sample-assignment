package com.example.myapplication1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder> {

    Context ctx;
    ArrayList<model> models;

    public Adapter(Context c,ArrayList<model> models){
        this.ctx = ctx;
        this.models = models;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder ViewHolder, int position) {

        ViewHolder.mName.setText(models.get(position).getName());
        ViewHolder.mMessage.setText(models.get(position).getMessage());
        ViewHolder.mimg.setImageResource(models.get(position).getImg());
        ViewHolder.mPending.setText(models.get(position).getPending());
        ViewHolder.mOnline.setText(models.get(position).getImg1());
        if(position==2){
            ViewHolder.mMessage.setTextColor(Color.parseColor("#6771C1"));
            ViewHolder.mMessage.setTypeface(null, Typeface.BOLD);
        }
        if(position!=0 && position!=2){
            ViewHolder.mPending.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            ViewHolder.mOnline.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }
        if(position==2)
            ViewHolder.mPending.setBackgroundColor(Color.parseColor("#00FFFFFF"));

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
