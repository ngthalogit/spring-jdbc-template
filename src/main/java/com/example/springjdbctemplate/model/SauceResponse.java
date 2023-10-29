package com.example.springjdbctemplate.model;

import com.example.springjdbctemplate.entity.Sauce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SauceResponse {
    private Long id;
    private Integer season;
    private String sauceName;
    private Long scoville;
    private Integer sauceNumber;

    public SauceResponse(Long id, Integer season, String sauceName, Long scoville, Integer sauceNumber) {
        this.id = id;
        this.season = season;
        this.sauceName = sauceName;
        this.scoville = scoville;
        this.sauceNumber = sauceNumber;
    }
    public SauceResponse(Sauce sauce) {
        this.id = sauce.getId();
        this.season = sauce.getSeason();
        this.sauceName = sauce.getSauceName();
        this.scoville = sauce.getScoville();
        this.sauceNumber = sauce.getSauceNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
