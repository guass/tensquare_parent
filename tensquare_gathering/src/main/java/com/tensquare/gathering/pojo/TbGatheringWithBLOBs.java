package com.tensquare.gathering.pojo;

import com.tensquare.gathering.pojo.TbGathering;

public class TbGatheringWithBLOBs extends TbGathering {
    
    private String summary;

    
    private String detail;

    
    public String getSummary() {
        return summary;
    }

    
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    
    public String getDetail() {
        return detail;
    }

    
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}