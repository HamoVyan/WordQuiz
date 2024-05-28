package com.example.wordquiz;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView point;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        point = itemView.findViewById(R.id.point_tv);
    }

}
