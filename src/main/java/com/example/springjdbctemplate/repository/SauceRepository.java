package com.example.springjdbctemplate.repository;

import com.example.springjdbctemplate.entity.Sauce;

import java.util.List;

public interface SauceRepository {
    int count();
    int countBySauceNameSeason(String sauceName, Integer season);
    Sauce findById(Long id);
    List<Sauce> findAll();
    int insert(Sauce sauce);
    int update(Sauce sauce);
    int delete(Long id);
    int batchInsert(List<Sauce> sauces);
}
