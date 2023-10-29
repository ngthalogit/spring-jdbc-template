package com.example.springjdbctemplate.service;

import com.example.springjdbctemplate.entity.Sauce;
import com.example.springjdbctemplate.model.RequestSauce;
import com.example.springjdbctemplate.model.SauceResponse;

import java.util.List;

public interface SauceService {
    Integer getNumberOfSauces();
    SauceResponse getSauceById(Long id);
    List<SauceResponse> getAllSauces();
    int insertSauce(RequestSauce requestSauce);
    int deleteSauce(Long id);
    int updateSauce(Long id, RequestSauce requestSauce);
    int insertSauces(List<RequestSauce> requestSauces);
}
