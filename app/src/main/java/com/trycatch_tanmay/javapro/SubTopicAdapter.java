package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.ViewHolder> {
    private Context context;
    private List<Topic> subTopics;

    public SubTopicAdapter(Context context, List<Topic> subTopics) {
        this.context = context;
        this.subTopics = subTopics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_topic_item_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Topic subtopic  = subTopics.get(position);
       int suTopicNUmber =position + 1;
       holder.subTopicNumberTextView.setText(suTopicNUmber + ".");
       holder.subTopicNameTextView.setText(subtopic.getTopicName());
        holder.subTopicContentTextView.setText(subtopic.getTopicContent()); // Add this line to display content

    }


    @Override
    public int getItemCount() {
        return subTopics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subTopicNumberTextView;
        TextView subTopicNameTextView;
        TextView subTopicContentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subTopicNumberTextView = itemView.findViewById(R.id.subTopicNumberTextView);
            subTopicNameTextView = itemView.findViewById(R.id.subTopicNameTextView);
            subTopicContentTextView = itemView.findViewById(R.id.subTopicContentTextView); // Add this line
        }
        }
        }


