package com.example.MakeYourTrip.RequestDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAvailableSeatsDto {
    private LocalDate journeyDate;
    private int transportId;

}
