package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

public class PojoInterview {
    @SerializedName("id")
    String id;

    @SerializedName("question")
    String question;

    @SerializedName("answer")
    String answer;

    public boolean isAnswerVisible() {
        return isAnswerVisible;
    }

    public void setAnswerVisible(boolean answerVisible) {
        isAnswerVisible = answerVisible;
    }

    // New field to manage the visibility of the answer
    boolean isAnswerVisible;

    public PojoInterview(String id, String question, String answer, boolean isAnswerVisible) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.isAnswerVisible = isAnswerVisible;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
}
