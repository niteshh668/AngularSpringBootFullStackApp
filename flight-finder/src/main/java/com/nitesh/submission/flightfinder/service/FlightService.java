package com.nitesh.submission.flightfinder.service;

import com.nitesh.submission.flightfinder.entities.Flight;

import java.util.List;

public interface FlightService {
     List<String> listOrigin(String keyword);
     List<Flight> findFlightByStation(String origin);
     }
