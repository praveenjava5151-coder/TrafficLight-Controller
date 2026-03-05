package com.traffic.trafficController.controller;

import com.traffic.trafficController.service.TrafficService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrafficController.class)
class TrafficControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrafficService trafficService;

    @Test
    void testPauseAPI() throws Exception {

        mockMvc.perform(post("/traffic/pause"))
                .andExpect(status().isOk())
                .andExpect(content().string("System paused"));
    }

    @Test
    void testResumeAPI() throws Exception {

        mockMvc.perform(post("/traffic/resume"))
                .andExpect(status().isOk())
                .andExpect(content().string("System resumed"));
    }
}