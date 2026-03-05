package com.traffic.trafficController;

import com.traffic.trafficController.model.Direction;
import com.traffic.trafficController.model.LightColor;
import com.traffic.trafficController.service.TrafficService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TrafficControllerApplicationTests {

	@Autowired
	TrafficService service;

	@Test
	void contextLoads() {
	}


	@Test
	void testGreenConflict() {

		service.changeLight("TRA-1", Direction.NORTH, LightColor.GREEN);

		assertThrows(RuntimeException.class, () -> {
			service.changeLight("TRA-1", Direction.EAST, LightColor.GREEN);
		});

	}
}
