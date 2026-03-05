package com.traffic.trafficController.controller;

import com.traffic.trafficController.model.Direction;
import com.traffic.trafficController.model.Intersection;
import com.traffic.trafficController.model.LightColor;
import com.traffic.trafficController.service.TrafficService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    private final TrafficService trafficService;

    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping("/{id}")
    public Intersection getState(@PathVariable String id) {
        return trafficService.getState(id);
    }

    @PostMapping("/{id}/change")
    public String changeLight(
            @PathVariable String id,
            @RequestParam Direction direction,
            @RequestParam LightColor color) {

        trafficService.changeLight(id, direction, color);

        return "Light changed";
    }

    @PostMapping("/pause")
    public String pause() {
        trafficService.pause();
        return "System paused";
    }

    @PostMapping("/resume")
    public String resume() {
        trafficService.resume();
        return "System resumed";
    }
}