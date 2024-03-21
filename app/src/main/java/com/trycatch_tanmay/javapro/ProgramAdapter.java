package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {
    private Context context;
    private List<Pojo_Program> pojoProgramList;

    public ProgramAdapter(Context context, List<Pojo_Program> pojoProgramList) {
        this.context = context;
        this.pojoProgramList = pojoProgramList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.program_itemview, parent, false);
        return new ViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Pojo_Program pojoProgram = pojoProgramList.get(position);
//        holder.programNameTextView.setText(pojoProgram.getProgramName());
//
//        // Set click listener for the card
//        holder.cardView.setOnClickListener(v -> {
//            // Open ProgramDetailsActivity
//            Intent intent = new Intent(context, ProgramDetalisActivity.class);
//            // Pass data to ProgramDetailsActivity if needed
//            intent.putExtra("programCode", pojoProgram.getProgramCode());
//            intent.putExtra("programOutput", pojoProgram.getOutput());
//            context.startActivity(intent);
//        });
//    }
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Pojo_Program pojoProgram = pojoProgramList.get(position);
    holder.programNameTextView.setText(pojoProgram.getProgramName());

    // Set click listener for the card
    holder.cardView1.setOnClickListener(v -> {
        // Open ProgramDetailsActivity
        Intent intent = new Intent(context, ProgramDetalisActivity.class);
        // Pass data to ProgramDetailsActivity
        intent.putExtra("programName", pojoProgram.getProgramName());
        intent.putExtra("programContent", pojoProgram.getProgramCode());
        context.startActivity(intent);
    });
}

    @Override
    public int getItemCount() {
        return pojoProgramList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView programNameTextView;
        RecyclerView prgrmTopicRecyclerView;
        CardView cardView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            programNameTextView = itemView.findViewById(R.id.programNameTextView);
            prgrmTopicRecyclerView = itemView.findViewById(R.id.prgrmTopicRecyclerView);
            cardView1 = itemView.findViewById(R.id.cardview1);
        }
    }
}
