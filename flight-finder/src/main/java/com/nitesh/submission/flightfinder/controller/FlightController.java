package com.nitesh.submission.flightfinder.controller;

import com.nitesh.submission.flightfinder.entities.Flight;
import com.nitesh.submission.flightfinder.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/flight-finder/")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Operation(summary = "Get a list of matching stations")
   @GetMapping("/stations/{stationKeyword}")
    public ResponseEntity<List<String>> getStations(@PathVariable("stationKeyword") String dest){
      try {
          return new ResponseEntity(flightService.listOrigin(dest.toUpperCase()), HttpStatus.OK);
      }
      catch (Exception e){
          return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
      }
   }

    @Operation(summary = "Get a list of flights origination from specified station")
    @GetMapping("/flights/{origin}")
    public ResponseEntity<List<Flight>> getFlights(@PathVariable("origin") String dest){
        try {
            return new ResponseEntity(flightService.findFlightByStation(dest.toUpperCase()), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

}
