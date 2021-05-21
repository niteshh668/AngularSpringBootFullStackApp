package com.nitesh.submission.flightfinder.service;

import com.nitesh.submission.flightfinder.entities.Flight;
import com.nitesh.submission.flightfinder.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<String> listOrigin(String keyword) {
        return flightRepository.search(keyword);
    }


    @Override
    public List<Flight> findFlightByStation(String origin) {
        return flightRepository.findByOrigin(origin);
    }
}
