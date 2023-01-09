package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {

    private final IWeatherService weatherService;

    @Autowired
    public WeatherApiRestController(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> addWeatherRecord(@RequestBody Weather record) {
        Weather savedRecord = weatherService.addWeatherRecord(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Weather>> getWeatherRecords(
            @RequestParam(name = "date", required = false) String date,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "sort", required = false) String sort) throws ParseException {
        Collection<Weather> foundRecords = weatherService.findWeatherRecordsByParams(date, city, sort);
        return ResponseEntity.ok(foundRecords);
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> getWeatherRecordById(@PathVariable Integer id) {
        Weather foundRecord = weatherService.getWeatherRecordById(id);
        if (foundRecord == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundRecord);
    }
}
