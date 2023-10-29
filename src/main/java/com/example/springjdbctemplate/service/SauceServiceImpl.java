package com.example.springjdbctemplate.service;

import com.example.springjdbctemplate.entity.Sauce;
import com.example.springjdbctemplate.entity.SauceBuilder;
import com.example.springjdbctemplate.model.RequestSauce;
import com.example.springjdbctemplate.model.SauceResponse;
import com.example.springjdbctemplate.model.SauceResponseBuilder;
import com.example.springjdbctemplate.repository.SauceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SauceServiceImpl implements SauceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SauceServiceImpl.class);
    private final SauceRepository sauceRepository;

    public SauceServiceImpl(SauceRepository sauceRepository) {
        this.sauceRepository = sauceRepository;
    }
    @Override
    public Integer getNumberOfSauces() {
        return sauceRepository.count();
    }
    @Override
    public SauceResponse getSauceById(Long id) {
        Sauce sauce = sauceRepository.findById(id);

        return new SauceResponseBuilder()
                .setId(sauce.getId())
                .setSauceName(sauce.getSauceName())
                .setSauceNumber(sauce.getSauceNumber())
                .setSeason(sauce.getSeason())
                .setScoville(sauce.getScoville())
                .createSauceResponse();
    }
    @Override
    public List<SauceResponse> getAllSauces() {
        List<Sauce> sauces = sauceRepository.findAll();
        return sauces.stream().map(SauceResponse::new).collect(Collectors.toList());
    }
    @Override
    public int insertSauce(RequestSauce requestSauce) {
        Sauce sauce = new SauceBuilder()
                .setSauceNumber(requestSauce.getSauceNumber())
                .setSauceName(requestSauce.getSauceName())
                .setSeason(requestSauce.getSeason())
                .setScoville(requestSauce.getScoville())
                .createSauce();
        if (sauceRepository.countBySauceNameSeason(sauce.getSauceName(), sauce.getSeason()) == 0) {
            return sauceRepository.insert(sauce);
        }
        return 0;
    }
    @Override
    public int deleteSauce(Long id) {
        try {
            Sauce existingSauce = sauceRepository.findById(id);
            if (Objects.nonNull(existingSauce)) {
                return sauceRepository.delete(id);
            }
        } catch (DataAccessException e) {
            LOGGER.info("Sauce with id = {} does not exist, cannot execute delete!", id);
        }
        return 0;
    }
    @Override
    public int updateSauce(Long id, RequestSauce requestSauce) {
        try {
            if (Objects.nonNull(sauceRepository.findById(id))) {
                Sauce sauce = new SauceBuilder()
                        .setId(id)
                        .setSauceNumber(requestSauce.getSauceNumber())
                        .setSauceName(requestSauce.getSauceName())
                        .setScoville(requestSauce.getScoville())
                        .setSeason(requestSauce.getSeason())
                        .createSauce();
                return sauceRepository.update(sauce);
            }

        } catch (DataAccessException e) {
            LOGGER.info("Sauce {} does not exist, cannot update", requestSauce.toString());
        }
        return 0;
    }

    // TODO
    @Override
    public int insertSauces(List<RequestSauce> requestSauces) {
        return 0;
    }
}
