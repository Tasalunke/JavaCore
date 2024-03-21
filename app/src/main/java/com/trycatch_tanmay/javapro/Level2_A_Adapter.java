package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;



public class Level2_A_Adapter extends PagerAdapter {
  private   Context context;
    private PojoLevel2_B pojoLevel2_b;
    private LayoutInflater layoutInflater;
    private Boolean isSelected = false;
    public Level2_A_Adapter(Context context, PojoLevel2_B pojoLevel2_b) {
        this.context = context;
        this.pojoLevel2_b = pojoLevel2_b;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pojoLevel2_b != null && pojoLevel2_b.getData() !=null ?pojoLevel2_b.getData().size():0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.level_2_itemview, container, false);
        TextView textViewData = itemView.findViewById(R.id.questionTextView);
        textViewData.setText(pojoLevel2_b.getData().get(position).getQuestion());
        TextView option1 = itemView.findViewById(R.id.option1RadioButton);
        option1.setText(pojoLevel2_b.getData().get(position).getOption1());
        TextView option2 = itemView.findViewById(R.id.option2RadioButton);
        option2.setText(pojoLevel2_b.getData().get(position).getOption2());
        TextView option3 = itemView.findViewById(R.id.option3RadioButton);
        option3.setText(pojoLevel2_b.getData().get(position).getOption3());
        TextView option4 = itemView.findViewById(R.id.option4RadioButton);
        option4.setText(pojoLevel2_b.getData().get(position).getOption4());

        int correctOption = Integer.parseInt(pojoLevel2_b.getData().get(position).getAnswer());
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

            if (checkin(optionNumber, correctOption)) {
                textView.setBackgroundColor(Color.parseColor("#91edb4"));
            } else {
                textView.setBackgroundColor(Color.parseColor("#ff666d"));

                TextView correctAnswerTextView = itemView.findViewById(R.id.correctAnswerTextView);
                correctAnswerTextView.setText("Correct Answer: " + correctOption);
                correctAnswerTextView.setVisibility(View.VISIBLE);
            }
        });
    }
    private boolean checkin(int selectedOption, int correctOption) {
        return selectedOption == correctOption;
    }
}
