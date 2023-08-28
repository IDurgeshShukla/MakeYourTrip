package com.example.MakeYourTrip.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightResultDto {
    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private String companyName;
    private String listOfStopInBetween;
}
