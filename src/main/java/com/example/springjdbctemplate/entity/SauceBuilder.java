package com.example.springjdbctemplate.entity;

public class SauceBuilder {
    private Long id;
    private Integer season;
    private String sauceName;
    private Long scoville;
    private Integer sauceNumber;

    public SauceBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SauceBuilder setSeason(Integer season) {
        this.season = season;
        return this;
    }

    public SauceBuilder setSauceName(String sauceName) {
        this.sauceName = sauceName;
        return this;
    }

    public SauceBuilder setScoville(Long scoville) {
        this.scoville = scoville;
        return this;
    }

    public SauceBuilder setSauceNumber(Integer sauceNumber) {
        this.sauceNumber = sauceNumber;
        return this;
    }

    public Sauce createSauce() {
        return new Sauce(id, season, sauceName, scoville, sauceNumber);
    }
}