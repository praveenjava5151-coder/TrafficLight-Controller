package com.traffic.trafficController.scheduler;

import com.traffic.trafficController.model.Direction;
import com.traffic.trafficController.model.LightColor;
import com.traffic.trafficController.service.TrafficService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TrafficScheduler {

    private final TrafficService trafficService;

    private int step = 0;

    public TrafficScheduler(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @Scheduled(fixedRate = 10000)
    public void changeLights() {

        if (trafficService.isPaused()) return;

        if (step % 2 == 0) {

            trafficService.changeLight("TRA-1", Direction.NORTH, LightColor.GREEN);
            trafficService.changeLight("TRA-1", Direction.EAST, LightColor.RED);

        } else {

            trafficService.changeLight("TRA-1", Direction.NORTH, LightColor.RED);
            trafficService.changeLight("TRA-1", Direction.EAST, LightColor.GREEN);

        }

        step++;
    }
}