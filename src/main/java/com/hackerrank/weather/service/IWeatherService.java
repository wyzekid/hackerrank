package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.model.WeatherEntity;

import java.text.ParseException;
import java.util.Collection;

public interface IWeatherService {

    Weather addWeatherRecord(Weather weather);

    Weather getWeatherRecordById(Integer id);

    Collection<Weather> findWeatherRecordsByParams(String date, String city, String sort) throws ParseException;

}
