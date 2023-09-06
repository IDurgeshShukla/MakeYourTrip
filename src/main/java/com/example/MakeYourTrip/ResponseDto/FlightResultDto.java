package com.example.MakeYourTrip.ResponseDto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
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
