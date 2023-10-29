package com.example.springjdbctemplate.model;

public class SauceResponseBuilder {
    private Long id;
    private Integer season;
    private String sauceName;
    private Long scoville;
    private Integer sauceNumber;

    public SauceResponseBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SauceResponseBuilder setSeason(Integer season) {
        this.season = season;
        return this;
    }

    public SauceResponseBuilder setSauceName(String sauceName) {
        this.sauceName = sauceName;
        return this;
    }

    public SauceResponseBuilder setScoville(Long scoville) {
        this.scoville = scoville;
        return this;
    }

    public SauceResponseBuilder setSauceNumber(Integer sauceNumber) {
        this.sauceNumber = sauceNumber;
        return this;
    }

    public SauceResponse createSauceResponse() {
        return new SauceResponse(id, season, sauceName, scoville, sauceNumber);
    }
}