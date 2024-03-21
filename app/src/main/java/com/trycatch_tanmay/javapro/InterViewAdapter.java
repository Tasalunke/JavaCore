package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class InterViewAdapter extends RecyclerView.Adapter<InterViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PojoInterview> pojoInterviews;

    public InterViewAdapter(Context context, ArrayList<PojoInterview> pojoInterviews) {
        this.context = context;
        this.pojoInterviews = pojoInterviews;
    }

    @NonNull
    @Override
    public InterViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.interview_itemview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterViewAdapter.ViewHolder holder, int position) {
//        PojoInterview interview = pojoInterviews.get(position);
//
//        // Set question text
//        holder.questionTextView.setText(interview.getQuestion());
//
//        // Set click listener for question item
//        holder.cardView.setOnClickListener(v -> {
//            // Toggle visibility of answer text
//            if (holder.answerTextView.getVisibility() == View.VISIBLE) {
//                holder.answerTextView.setVisibility(View.GONE);
//            } else {
//                // Set answer text and make it visible
//                holder.answerTextView.setText(interview.getAnswer());
//                holder.answerTextView.setVisibility(View.VISIBLE);
//            }
//        });
//       PojoInterview interview = pojoInterviews.get(position);
//
//                // Set question text
//                holder.questionTextView.setText(interview.getQuestion());
//
//                // Set answer text and visibility
//                holder.answerTextView.setText(interview.getAnswer());
//                holder.answerTextView.setVisibility(interview.isAnswerVisible() ? View.VISIBLE : View.GONE);
//
//                // Set click listener for question item
//                holder.cardView.setOnClickListener(v -> {
//                    // Toggle visibility of answer text
//                    if (holder.answerTextView.getVisibility() == View.VISIBLE) {
//                        holder.answerTextView.setVisibility(View.GONE);
//                    } else {
//                        holder.answerTextView.setVisibility(View.VISIBLE);
//            }
//        });
        PojoInterview interview = pojoInterviews.get(position);

        // Set question text
        holder.questionTextView.setText(interview.getQuestion());

        // Set answer text and visibility
        holder.answerTextView.setText(interview.getAnswer());
        holder.answerTextView.setVisibility(interview.isAnswerVisible() ? View.VISIBLE : View.GONE);

        // Set click listener for question item
        holder.cardView.setOnClickListener(v -> {
            // Toggle visibility of answer text
            interview.setAnswerVisible(!interview.isAnswerVisible());
            notifyDataSetChanged(); // Notify the adapter that the data set has changed
        });
    }

    @Override
    public int getItemCount() {
        return pojoInterviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView, answerTextView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            answerTextView = itemView.findViewById(R.id.answer); // Initialize answerTextView
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
