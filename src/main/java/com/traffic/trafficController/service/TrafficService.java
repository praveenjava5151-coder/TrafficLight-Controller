package com.traffic.trafficController.service;

import com.traffic.trafficController.model.*;
import com.traffic.trafficController.repository.TrafficHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TrafficService {

    private final Map<String, Intersection> intersections = new ConcurrentHashMap<>();

    private boolean paused = false;

    private final TrafficHistoryRepository historyRepository;

    public TrafficService(TrafficHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        intersections.put("TRA-1", new Intersection("TRA-1"));
    }

    public Intersection getState(String id) {
        return intersections.get(id);
    }

    public synchronized void changeLight(String id, Direction direction, LightColor color) {

        Intersection intersection = intersections.get(id);

        if (color == LightColor.GREEN) {

            for (TrafficLight light : intersection.getLights().values()) {

                if (light.getColor() == LightColor.GREEN) {
                    throw new RuntimeException("Another direction already GREEN");
                }
            }
        }

        intersection.getLights().get(direction).setColor(color);

        historyRepository.save(
                new TrafficHistory(id, direction.name(), color.name())
        );
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }
}