package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {

    List<WeatherEntity> findWeatherByCityInIgnoreCase(Collection<String> cityNames);
    List<WeatherEntity> findWeatherByDateOrderByIdAsc(Date date);

}
