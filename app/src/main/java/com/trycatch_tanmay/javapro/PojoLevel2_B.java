package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoLevel2_B {
    @SerializedName("data")
    List<PojoLevel2> data;

    @SerializedName("last_update")
    String lastUpdate;


    public void setData(List<PojoLevel2> data) {
        this.data = data;
    }
    public List<PojoLevel2> getData() {
        return data;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
}
