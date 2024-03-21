package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class chpAdapter extends RecyclerView.Adapter<chpAdapter.ViewHolder> {
          private Context context;
        private List<chppojo> chppojos;

        public chpAdapter(Context context, List<chppojo> chppojos) {
            this.context = context;
            this.chppojos = chppojos;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.chp_itemview, parent, false);
            return new ViewHolder(view);
        }

//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            chppojo item = chppojos.get(position);
//
//            // Display chapter data
//            List<Chapter> chapters = item.getChapter();
//            if (chapters != null && !chapters.isEmpty()) {
//                Chapter chapter = chapters.get(0);
//                holder.chapterNameTextView.setText(chapter.getChapterName());
//
//                List<Topic> topics = item.getTopic();
//                if (topics != null && !topics.isEmpty()) {
//                    // If subtopics exist, set up RecyclerView to display them
//                    holder.subTopicRecyclerView.setVisibility(View.VISIBLE);
//                    TopicAdapter topicAdapter = new TopicAdapter(context, topics);
//                    holder.subTopicRecyclerView.setAdapter(topicAdapter);
//
//                    // Set a click listener on the chapter item
//                    holder.itemView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            // Handle the click event to expand or collapse the subtopics
//                            if (holder.subTopicRecyclerView.getVisibility() == View.VISIBLE) {
//                                holder.subTopicRecyclerView.setVisibility(View.GONE);
//                            } else {
//                                holder.subTopicRecyclerView.setVisibility(View.VISIBLE);
//                            }
//                        }
//                    });
//                } else {
//                    // If no subtopics, hide the RecyclerView
//                    holder.subTopicRecyclerView.setVisibility(View.GONE);
//                }
//            } else {
//                // Handle the case where chapters are empty
//                holder.chapterNameTextView.setText("No Chapter Available");
//                holder.subTopicRecyclerView.setVisibility(View.GONE);
//            }
//        }
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    chppojo item = chppojos.get(position);

    // Display chapter data
    List<Chapter> chapters = item.getChapter();
    if (chapters != null && !chapters.isEmpty()) {
        Chapter chapter = chapters.get(0);
        holder.chapterNameTextView.setText(chapter.getChapterName());

        List<Topic> topics = item.getTopic();
        if (topics != null && !topics.isEmpty()) {
            // If subtopics exist, set up RecyclerView to display them
            holder.subTopicRecyclerView.setVisibility(View.GONE); // Set initial visibility to GONE

            // Set up RecyclerView and adapter
            TopicAdapter topicAdapter = new TopicAdapter(context, topics);
            holder.subTopicRecyclerView.setAdapter(topicAdapter);

            // Set a click listener on the chapter item
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle the click event to expand or collapse the subtopics
                    if (holder.subTopicRecyclerView.getVisibility() == View.VISIBLE) {
                        holder.subTopicRecyclerView.setVisibility(View.GONE);
                    } else {
                        holder.subTopicRecyclerView.setVisibility(View.VISIBLE);
                    }
                }
            });
        } else {
            // If no subtopics, hide the RecyclerView
            holder.subTopicRecyclerView.setVisibility(View.GONE);
        }
    } else {
        // Handle the case where chapters are empty
        holder.chapterNameTextView.setText("No Chapter Available");
        holder.subTopicRecyclerView.setVisibility(View.GONE);
    }
}


    @Override
        public int getItemCount() {
            return chppojos.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView chapterNameTextView;
            ImageView dropDownArrow;
            RecyclerView subTopicRecyclerView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                chapterNameTextView = itemView.findViewById(R.id.chapterNameTextView);
                dropDownArrow = itemView.findViewById(R.id.dropDownArrow);
                subTopicRecyclerView = itemView.findViewById(R.id.subTopicRecyclerView);
                subTopicRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            }
        }
    }

