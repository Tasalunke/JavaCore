package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

public class Topic {

    @SerializedName("topic_id")
    String topicId;

    @SerializedName("topic_name")
    String topicName;

    @SerializedName("topic_content")
    String topicContent;


    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
    public String getTopicId() {
        return topicId;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    public String getTopicName() {
        return topicName;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }
    public String getTopicContent() {
        return topicContent;
    }

}