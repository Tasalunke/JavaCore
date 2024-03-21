package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class chppojo {
    @SerializedName("chapter")
    List<Chapter> chapter;
    @SerializedName("topic")
    List<Topic> topic;

    public List<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }


}






