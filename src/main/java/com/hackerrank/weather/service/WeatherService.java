package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherService implements IWeatherService {

    private final WeatherRepository weatherRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);


    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Override
    public Weather addWeatherRecord(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public Optional<Weather> getWeatherRecordById(Integer id) {
        return weatherRepository.findById(id);
    }

    @Override
    public Collection<Weather> findWeatherRecordsByParams(String date, String city, String sort) throws ParseException {
        List<Weather> resultList;

        if (StringUtils.isEmpty(date)) {
            resultList = weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        } else {
            Date parsedDate = formatter.parse(date.split("=")[1]);
            resultList = weatherRepository.findWeatherByDateOrderByIdAsc(parsedDate);
        }

        if (!StringUtils.isEmpty(city)) {
            List<String> lowerCaseCities = Arrays.stream(city.split(","))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
            resultList = resultList.stream()
                    .filter(Objects::nonNull)
                    .filter(weather -> weather.getCity() != null)
                    .filter(weather -> lowerCaseCities.contains(weather.getCity().toLowerCase()))
                    .collect(Collectors.toList());
        }
        boolean sortOrderAsc = true;
        if (StringUtils.isEmpty(sort)) {
            return resultList;
        } else if (sort.equals("-date")) {
            sortOrderAsc = false;
        }

        if (sortOrderAsc) {
            resultList.sort((Comparator) (o1, o2) -> {

                Date date1 = ((Weather) o1).getDate();
                Date date2 = ((Weather) o2).getDate();
                int sComp = date1.compareTo(date2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer id1 = ((Weather) o1).getId();
                Integer id2 = ((Weather) o2).getId();
                return id1.compareTo(id2);
            });
        }  else {
            resultList.sort((Comparator) (o1, o2) -> {

                Date date1 = ((Weather) o1).getDate();
                Date date2 = ((Weather) o2).getDate();
                int sComp = date2.compareTo(date1);

                if (sComp != 0) {
                    return sComp;
                }

                Integer id1 = ((Weather) o1).getId();
                Integer id2 = ((Weather) o2).getId();
                return id1.compareTo(id2);
            });
        }
        return resultList;
    }

}
