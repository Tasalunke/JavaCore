package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoLevel3_A {
    @SerializedName("data")
    List<PojoLevel3_B> data;

    @SerializedName("last_update")
    String lastUpdate;


    public void setData(List<PojoLevel3_B> data) {
        this.data = data;
    }
    public List<PojoLevel3_B> getData() {
        return data;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
}
