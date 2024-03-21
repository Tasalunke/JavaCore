package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

public class PojoQuizLevel {
    @SerializedName("id")
    String id;

    @SerializedName("quiz_cat_name")
    String quizCatName;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setQuizCatName(String quizCatName) {
        this.quizCatName = quizCatName;
    }
    public String getQuizCatName() {
        return quizCatName;
    }

}

