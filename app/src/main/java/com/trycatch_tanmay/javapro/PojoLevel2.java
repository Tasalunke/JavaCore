package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

public class PojoLevel2 {

    @SerializedName("id")
    String id;

    @SerializedName("quiz_category_id")
    String quizCategoryId;

    @SerializedName("question")
    String question;

    @SerializedName("option_1")
    String option1;

    @SerializedName("option_2")
    String option2;

    @SerializedName("option_3")
    String option3;

    @SerializedName("option_4")
    String option4;

    @SerializedName("answer")
    String answer;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setQuizCategoryId(String quizCategoryId) {
        this.quizCategoryId = quizCategoryId;
    }
    public String getQuizCategoryId() {
        return quizCategoryId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption1() {
        return option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption2() {
        return option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption3() {
        return option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getOption4() {
        return option4;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
}
