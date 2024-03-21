package com.trycatch_tanmay.javapro;

import com.google.gson.annotations.SerializedName;

public class Pojo_Program {
    @SerializedName("id")
    String id;

    @SerializedName("program_name")
    String programName;

    @SerializedName("program_code")
    String programCode;

    @SerializedName("output")
    String output;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
    public String getProgramName() {
        return programName;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }
    public String getProgramCode() {
        return programCode;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    public String getOutput() {
        return output;
    }
}
