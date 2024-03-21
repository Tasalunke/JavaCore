package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoIntermediate_level_2_A {
    @SerializedName("data")
    List<PojoIntermediate_level_2_B> data;

    @SerializedName("last_update")
    String lastUpdate;


    public void setData(List<PojoIntermediate_level_2_B> data) {
        this.data = data;
    }
    public List<PojoIntermediate_level_2_B> getData() {
        return data;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
}
