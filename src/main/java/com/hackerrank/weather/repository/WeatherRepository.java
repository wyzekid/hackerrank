package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findWeatherByCityInIgnoreCase(Collection<String> cityNames);
    List<Weather> findWeatherByDateOrderByIdAsc(Date date);

}
