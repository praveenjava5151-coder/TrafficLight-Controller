package com.traffic.trafficController.service;

import com.traffic.trafficController.model.Direction;
import com.traffic.trafficController.model.LightColor;
import com.traffic.trafficController.repository.TrafficHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TrafficServiceTest {

    private TrafficService trafficService;

    @BeforeEach
    void setup() {

        TrafficHistoryRepository repository = Mockito.mock(TrafficHistoryRepository.class);
        trafficService = new TrafficService(repository);

    }

    @Test
    void testChangeLightSuccess() {

        trafficService.changeLight("TRA-1", Direction.NORTH, LightColor.GREEN);

        assertEquals(
                LightColor.GREEN,
                trafficService.getState("TRA-1").getLights().get(Direction.NORTH).getColor()
        );

    }

    @Test
    void testGreenConflict() {

        trafficService.changeLight("TRA-1", Direction.NORTH, LightColor.GREEN);

        Exception exception = assertThrows(RuntimeException.class, () -> {

            trafficService.changeLight("TRA-1", Direction.EAST, LightColor.GREEN);

        });

        assertTrue(exception.getMessage().contains("Another direction already GREEN"));

    }

    @Test
    void testPauseSystem() {

        trafficService.pause();

        assertTrue(trafficService.isPaused());

    }

    @Test
    void testResumeSystem() {

        trafficService.pause();
        trafficService.resume();

        assertFalse(trafficService.isPaused());

    }

}