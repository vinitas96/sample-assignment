package com.example.assintern;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Discussion> mData;

    public RecyclerViewAdapter(Context mContext, List<Discussion> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate( R.layout.rows, parent,false );
        MyViewHolder vHolder = new MyViewHolder( v );

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_Name.setText( mData.get( position ).getName() );
        holder.tv_message.setText( mData.get( position ).getMessage() );
        holder.img.setImageResource( mData.get( position ).getPhoto() );
        holder.tv_Pending.setText(mData.get(position).getPending());
        holder.tv_Online.setText(mData.get(position).getImg());
        if(position==2){
            holder.tv_message.setTextColor( Color.parseColor("#6771C1"));
            holder.tv_message.setTypeface(null, Typeface.BOLD);
        }
        if(position!=0 && position!=2){
            holder.tv_Pending.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            holder.tv_Online.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }
        if(position==2)
            holder.tv_Pending.setBackgroundColor(Color.parseColor("#00FFFFFF"));


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_Name;
        private TextView tv_message;
        private ImageView img;
        private TextView tv_Pending;
        private TextView tv_Online;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            tv_Name = (TextView) itemView.findViewById( R.id.name );
            tv_message = (TextView) itemView.findViewById( R.id.message );
            img = (ImageView) itemView.findViewById( R.id.img );
            tv_Pending = (TextView) itemView.findViewById( R.id.pending );
            tv_Online = (TextView) itemView.findViewById( R.id.online );

        }
    }
}
