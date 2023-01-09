package com.hackerrank.weather.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private Date date;
    @Column
    private Float lat;
    @Column
    private Float lon;
    @Column
    private String city;
    @Column
    private String state;

    @ElementCollection
    @CollectionTable(name = "my_list", joinColumns = @JoinColumn(name = "id"))
    private List<Double> temperatures;

    public WeatherEntity(Integer id, Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.id = id;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public WeatherEntity(Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public WeatherEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Double> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Double> temperatures) {
        this.temperatures = temperatures;
    }
}
