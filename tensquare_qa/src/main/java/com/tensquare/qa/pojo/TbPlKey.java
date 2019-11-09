package com.tensquare.qa.pojo;

public class TbPlKey {

    private String problemid;


    private String labelid;


    public String getProblemid() {
        return problemid;
    }


    public void setProblemid(String problemid) {
        this.problemid = problemid == null ? null : problemid.trim();
    }


    public String getLabelid() {
        return labelid;
    }


    public void setLabelid(String labelid) {
        this.labelid = labelid == null ? null : labelid.trim();
    }
}