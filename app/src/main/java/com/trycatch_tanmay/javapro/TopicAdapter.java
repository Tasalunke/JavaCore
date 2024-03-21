package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class TopicAdapter  extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private Context context;
    private List<Topic> topics;

    public TopicAdapter(Context context, List<Topic> topics) {
        this.context = context;
        this.topics = topics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.topic_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Topic topic = topics.get(position);
        holder.topicNameTextView.setText(topic.getTopicName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event to show subtopic content
                String subtopicContent = getTopicContent(topic);
                if (subtopicContent != null) {
                    // Start a new activity or show a dialog with the subtopic content
                    Intent intent = new Intent(context, ChpDetalisActivity.class);
                    intent.putExtra("topic_id", topic.getTopicId());
                    intent.putExtra("subtopic", topic.getTopicName());
                    intent.putExtra("content", subtopicContent);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topicNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicNameTextView = itemView.findViewById(R.id.subTopicNameTextView);
        }
    }

    // Add a method to get the content of a specific topic
    public String getTopicContent(Topic topic) {
        // Implement logic to retrieve content based on the provided topic
        // For example, if each topic has a content field, you can simply return it
        return topic != null ? topic.getTopicContent() : null;
    }
}