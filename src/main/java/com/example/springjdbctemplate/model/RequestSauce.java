package com.example.springjdbctemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestSauce {
    private Integer season;
    private String sauceName;
    private Long scoville;
    private Integer sauceNumber;

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public Long getScoville() {
        return scoville;
    }

    public void setScoville(Long scoville) {
        this.scoville = scoville;
    }

    public Integer getSauceNumber() {
        return sauceNumber;
    }

    public void setSauceNumber(Integer sauceNumber) {
        this.sauceNumber = sauceNumber;
    }

    @Override
    public String toString() {
        return "RequestSauce{" +
                "season=" + season +
                ", sauceName='" + sauceName + '\'' +
                ", scoville=" + scoville +
                ", sauceNumber=" + sauceNumber +
                '}';
    }
}
