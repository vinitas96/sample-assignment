package com.example.myapplication1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder{
    ImageView mimg ;
    TextView mName, mMessage , mPending,mOnline;
    public Holder(@NonNull View itemView){
        super(itemView);

        this.mimg = itemView.findViewById(R.id.img);
        this.mName = itemView.findViewById(R.id.name);
        this.mMessage = itemView.findViewById(R.id.message);
        this.mOnline = itemView.findViewById(R.id.online);
        this.mPending = itemView.findViewById(R.id.pending);

    }
}
