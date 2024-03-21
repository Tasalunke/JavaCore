package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoLevel1_B {
    @SerializedName("data")
    List<PojoLevel1data> data;

    @SerializedName("last_update")
    String lastUpdate;


    public void setData(List<PojoLevel1data> data) {
        this.data = data;
    }
    public List<PojoLevel1data> getData() {
        return data;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
}
