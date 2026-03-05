package com.traffic.trafficController.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Intersection {

    private String id;

    private Map<Direction, TrafficLight> lights = new ConcurrentHashMap<>();

    public Intersection(String id) {
        this.id = id;

        lights.put(Direction.NORTH, new TrafficLight(Direction.NORTH, LightColor.RED));
        lights.put(Direction.SOUTH, new TrafficLight(Direction.SOUTH, LightColor.RED));
        lights.put(Direction.EAST, new TrafficLight(Direction.EAST, LightColor.RED));
        lights.put(Direction.WEST, new TrafficLight(Direction.WEST, LightColor.RED));
    }

    public Map<Direction, TrafficLight> getLights() {
        return lights;
    }

}
