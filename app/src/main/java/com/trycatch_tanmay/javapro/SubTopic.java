package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

public class SubTopic {
    @SerializedName("chapter_id")
    String chapterId;

    @SerializedName("chapter_name")
    String chapterName;


    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }
    public String getChapterId() {
        return chapterId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public String getChapterName() {
        return chapterName;
    }
}
