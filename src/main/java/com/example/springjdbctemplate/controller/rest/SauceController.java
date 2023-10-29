package com.example.springjdbctemplate.controller.rest;

import com.example.springjdbctemplate.model.RequestSauce;
import com.example.springjdbctemplate.model.SauceResponse;
import com.example.springjdbctemplate.service.SauceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/rest")
public class SauceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SauceController.class);
    private final SauceService sauceService;

    public SauceController(SauceService sauceService) {
        this.sauceService = sauceService;
    }

    @GetMapping("/sauces/count")
    public ResponseEntity<Integer> getNumberOfSauces() {
        return ResponseEntity.ok(sauceService.getNumberOfSauces());
    }

    @GetMapping("/sauces/{id}")
    public ResponseEntity<SauceResponse> getSauceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(sauceService.getSauceById(id));
    }

    @GetMapping("/sauces")
    public ResponseEntity<List<SauceResponse>> getAllSauces() {
        return ResponseEntity.ok(sauceService.getAllSauces());
    }

    @PostMapping("/sauces/add")
    public ResponseEntity<String> addSauce(@RequestBody RequestSauce requestSauce) {
        if (sauceService.insertSauce(requestSauce) != 0) {
            LOGGER.info("insert {} into db successfully", requestSauce.toString());
            return ResponseEntity.ok(requestSauce + " inserted");
        } else {
            LOGGER.info("{} existed in db, cannot insert more!", requestSauce.toString());
        }

        return ResponseEntity.ok(requestSauce.toString() + " existed, cannot insert more!");
    }

    @DeleteMapping("/sauces/delete/{id}")
    public ResponseEntity<String> deleteSauce(@PathVariable("id") Long id) {
        if (sauceService.deleteSauce(id) != 0) {
            return ResponseEntity.ok("deleted sauce with id = " + id);
        }
        return ResponseEntity.ok("Sauce with id = %s does not exist, cannot execute delete!".formatted(id));
    }

    @PostMapping("/sauces/update/{id}")
    public ResponseEntity<String> updateSauce(@PathVariable("id") Long id, @RequestBody RequestSauce requestSauce) {
        if (sauceService.updateSauce(id, requestSauce) != 0) {
            LOGGER.info("update {} into db successfully", requestSauce.toString());
            return ResponseEntity.ok("sauce id = %s updated with value ".formatted(id) + requestSauce.toString());
        }
        return ResponseEntity.ok("Sauce with id = %s does not exist, cannot execute update!".formatted(id));
    }

    // TODO
    @PostMapping("sauces/add/batch")
    public ResponseEntity<String> insertSauces(@RequestBody List<RequestSauce> requestSauces) {
        return ResponseEntity.ok("");
    }
}
