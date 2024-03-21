package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;



public class Intermediate_A_Adapter extends PagerAdapter {
    private Context context;
    private PojoIntermediate_1_A pojoIntermediate1A;
    private boolean isSelected = false;

    public Intermediate_A_Adapter(Context context, PojoIntermediate_1_A pojoIntermediate1A) {
        this.context = context;
        this.pojoIntermediate1A = pojoIntermediate1A;
    }

    @Override
    public int getCount() {
        return pojoIntermediate1A != null && pojoIntermediate1A.getData() != null ? pojoIntermediate1A.getData().size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.intermediate_1_itemview, container, false);

        TextView textViewData = itemView.findViewById(R.id.questionTextView);
        textViewData.setText(pojoIntermediate1A.getData().get(position).getQuestion());
        TextView option1 = itemView.findViewById(R.id.option1RadioButton);
        option1.setText(pojoIntermediate1A.getData().get(position).getOption1());
        TextView option2 = itemView.findViewById(R.id.option2RadioButton);
        option2.setText(pojoIntermediate1A.getData().get(position).getOption2());
        TextView option3 = itemView.findViewById(R.id.option3RadioButton);
        option3.setText(pojoIntermediate1A.getData().get(position).getOption3());
        TextView option4 = itemView.findViewById(R.id.option4RadioButton);
        option4.setText(pojoIntermediate1A.getData().get(position).getOption4());

        int correctOption = Integer.parseInt(pojoIntermediate1A.getData().get(position).getAnswer());
        setOptionClickListener(option1, 1, correctOption, itemView);
        setOptionClickListener(option2, 2, correctOption, itemView);
        setOptionClickListener(option3, 3, correctOption, itemView);
        setOptionClickListener(option4, 4, correctOption, itemView);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    private void setOptionClickListener(TextView textView, int optionNumber, int correctOption, View itemView) {
        textView.setOnClickListener(v -> {
            isSelected = false;

            if (checkAnswer(optionNumber, correctOption)) {
                textView.setBackgroundColor(Color.parseColor("#91edb4"));
            } else {
                textView.setBackgroundColor(Color.parseColor("#ff666d"));

                TextView correctAnswerTextView = itemView.findViewById(R.id.correctAnswerTextView);
                correctAnswerTextView.setText("Correct Answer: " + correctOption);
                correctAnswerTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private boolean checkAnswer(int selectedOption, int correctOption) {
        return selectedOption == correctOption;
    }
}
