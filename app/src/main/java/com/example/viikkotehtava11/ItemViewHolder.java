package com.example.viikkotehtava11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView ItemName, ItemDesc;
    ImageView ButtonDelete, ButtonEdit;
    EditText EditName, EditDesc;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ItemName = itemView.findViewById(R.id.textViewName);
        ItemDesc = itemView.findViewById(R.id.textViewDescription);
        ButtonDelete = itemView.findViewById(R.id.imgDelete);
        ButtonEdit = itemView.findViewById(R.id.imgEdit);
        EditName = itemView.findViewById(R.id.editName);
        EditDesc = itemView.findViewById(R.id.editDescription);
    }
}
