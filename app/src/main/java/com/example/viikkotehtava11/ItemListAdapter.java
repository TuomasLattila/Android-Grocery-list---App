package com.example.viikkotehtava11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items)  {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.text_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.ItemName.setText(items.get(position).getName());
        holder.ItemDesc.setText(items.get(position).getDescription());

        //delete item
        holder.ButtonDelete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ItemStorage.getInstance().removeItem(items.get(pos).getId());
            notifyItemRemoved(pos);
        });

        //edit item
        holder.ButtonEdit.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();

            if (holder.EditName.getVisibility() == View.VISIBLE)  {
                Item item = ItemStorage.getInstance().getItemList().get(pos);
                item.setName(holder.EditName.getText().toString());
                item.setDescription(holder.EditDesc.getText().toString());
                holder.EditName.setVisibility(View.GONE);
                holder.EditDesc.setVisibility(View.GONE);
                notifyDataSetChanged();
            } else {
                holder.EditName.setVisibility(View.VISIBLE);
                holder.EditDesc.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
