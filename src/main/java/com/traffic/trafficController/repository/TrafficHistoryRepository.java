package com.traffic.trafficController.repository;


import com.traffic.trafficController.model.TrafficHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficHistoryRepository extends JpaRepository<TrafficHistory, Long> {
}