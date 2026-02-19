package com.example.voiceactorfinder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView,emailView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
