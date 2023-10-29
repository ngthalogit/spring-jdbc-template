package com.example.springjdbctemplate.entity;

public class Sauce {
    private Long id;
    private Integer season;
    private String sauceName;
    private Long scoville;
    private Integer sauceNumber;

    public Sauce(Long id, Integer season, String sauceName, Long scoville, Integer sauceNumber) {
        this.id = id;
        this.season = season;
        this.sauceName = sauceName;
        this.scoville = scoville;
        this.sauceNumber = sauceNumber;
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

    @Override
    public String toString() {
        return "Sauce{" +
                "id=" + id +
                ", season=" + season +
                ", sauceName='" + sauceName + '\'' +
                ", scoville=" + scoville +
                ", sauceNumber=" + sauceNumber +
                '}';
    }
}
