package com.nitesh.submission.flightfinder.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="flight_identifier")
    private String flightIdentifier;

    @Column(name="flt_num")
    private Long fltNum;

    @Column(name="scheduled_origin_gate")
    private String scheduledOriginGate;

    @Column(name="scheduled_destination_gate")
    private String scheduledDestinationGate;

    @Column(name="out_gmt")
    private LocalDateTime outGmt;

    @Column(name="in_gmt")
    private LocalDateTime inGmt;

    @Column(name="off_gmt")
    private LocalDateTime offGmt;

    @Column(name="on_gmt")
    private LocalDateTime onGmt;

    @Column(name="destination")
    private String destination;

    @Column(name="origin")
    private String origin;

    @Column(name="destination_full_name")
    private String destinationFullName;

    @Column(name="origin_full_name")
    private String originFullName;


}
