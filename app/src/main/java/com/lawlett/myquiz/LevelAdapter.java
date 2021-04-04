package com.lawlett.myquiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {
    ArrayList<String> levels;
    OnItemClick onItemClick;

    public LevelAdapter(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level, parent, false);
        return new LevelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
        holder.onBind(levels.get(position));
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    public void getLevel(ArrayList<String> levels) {
        this.levels = levels;
    }

    public class LevelViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public LevelViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.btn_level);
        }

        public void onBind(String level) {
            button.setText(level);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.onClick(getAdapterPosition());
                }
            });
        }
    }
}

