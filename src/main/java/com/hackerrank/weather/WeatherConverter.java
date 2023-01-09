package com.hackerrank.weather;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.model.WeatherEntity;

public class WeatherConverter {

    public static Weather toDto(WeatherEntity weatherEntity) {
        Weather result = new Weather();
        result.setId(weatherEntity.getId());
        result.setCity(weatherEntity.getCity());
        result.setLat(weatherEntity.getLat());
        result.setLon(weatherEntity.getLon());
        result.setState(weatherEntity.getState());
        result.setTemperatures(weatherEntity.getTemperatures());
        return result;
    }

    public static WeatherEntity toEntity(Weather weather) {
        WeatherEntity result = new WeatherEntity();
        result.setId(weather.getId());
        result.setCity(weather.getCity());
        result.setLat(weather.getLat());
        result.setLon(weather.getLon());
        result.setState(weather.getState());
        result.setTemperatures(weather.getTemperatures());
        return result;
    }
}
