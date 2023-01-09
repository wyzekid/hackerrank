package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;

import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;

public interface IWeatherService {

    Weather addWeatherRecord(Weather weather);

    Optional<Weather> getWeatherRecordById(Integer id);

    Collection<Weather> findWeatherRecordsByParams(String date, String city, String sort) throws ParseException;

}
