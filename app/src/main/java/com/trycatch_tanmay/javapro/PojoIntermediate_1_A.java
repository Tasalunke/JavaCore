package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoIntermediate_1_A {
    @SerializedName("data")
    List<Pojo_inter_1_B> data;

    @SerializedName("last_update")
    String lastUpdate;


    public void setData(List<Pojo_inter_1_B> data) {
        this.data = data;
    }
    public List<Pojo_inter_1_B> getData() {
        return data;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
}
