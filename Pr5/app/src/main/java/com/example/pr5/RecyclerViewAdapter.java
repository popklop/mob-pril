package com.example.pr5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private List<DataModel> items;

    public RecyclerViewAdapter(List<DataModel> items)
    {
        this.items=items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position)
    {
        DataModel item = items.get(position);
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(item.getImageResource());
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;
        public ViewHolder(View view)
        {
            super(view);
            textView = view.findViewById(R.id.textView2);
            imageView=view.findViewById(R.id.imageView);
        }
    }
}
