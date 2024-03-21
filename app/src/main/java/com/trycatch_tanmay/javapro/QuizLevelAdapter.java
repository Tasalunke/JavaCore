package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class QuizLevelAdapter extends RecyclerView.Adapter<QuizLevelAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PojoQuizLevel> pojoQuizLevels;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(String levelName);
    }

    public QuizLevelAdapter(Context context, ArrayList<PojoQuizLevel> pojoQuizLevels, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.pojoQuizLevels = pojoQuizLevels;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nysingle_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.demo.setText(pojoQuizLevels.get(position).getQuizCatName());
    }

    @Override
    public int getItemCount() {
        return pojoQuizLevels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView demo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            demo = itemView.findViewById(R.id.demo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        String levelName = pojoQuizLevels.get(position).getQuizCatName();
                        onItemClickListener.onItemClick(levelName);
                    }
                }
            });
        }
    }
}
