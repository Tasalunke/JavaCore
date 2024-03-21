package com.trycatch_tanmay.javapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;



import java.util.ArrayList;

public class Level1Adapter extends PagerAdapter {

    private Context context;
    private ArrayList<PojoLevel1data> dataList;


    public Level1Adapter(Context context, ArrayList<PojoLevel1data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.level_1_itemview, container, false);

        // Bind data to the itemView using dataList.get(position)
        // For example:
        TextView questionTextView = itemView.findViewById(R.id.questionTextView);
        TextView option1TextView = itemView.findViewById(R.id.option1RadioButton);
        TextView option2TextView = itemView.findViewById(R.id.option2RadioButton);
        TextView option3TextView = itemView.findViewById(R.id.option3RadioButton);
        TextView answerTextView = itemView.findViewById(R.id.correctAnswerTextView);

        PojoLevel1data currentItem = dataList.get(position);

        questionTextView.setText(currentItem.getQuestion());
        option1TextView.setText(currentItem.getOption1());
        option2TextView.setText(currentItem.getOption2());
        option3TextView.setText(currentItem.getOption3());
        answerTextView.setText(currentItem.getAnswer());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
