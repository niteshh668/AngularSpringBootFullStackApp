package com.nitesh.submission.flightfinder.repositories;


import com.nitesh.submission.flightfinder.entities.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository  extends CrudRepository<Flight,Long> {

    @Query(value = "select DISTINCT origin  from flights where origin like %:keyword%", nativeQuery = true)
    public List<String> search(@Param ("keyword") String keyword);

    public List<Flight> findByOrigin(String origin);



































}
