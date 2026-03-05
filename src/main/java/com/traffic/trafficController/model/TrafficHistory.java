package com.traffic.trafficController.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TrafficHistory {

    @Id
    @GeneratedValue
    private Long id;

    private String intersectionId;

    private String direction;

    private String color;

    private LocalDateTime time;

    public TrafficHistory() {}

    public TrafficHistory(String intersectionId, String direction, String color) {
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.color = color;
        this.time = LocalDateTime.now();
    }

}