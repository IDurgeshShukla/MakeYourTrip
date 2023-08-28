package com.example.MakeYourTrip.RequestDtos;

import com.example.MakeYourTrip.Enums.City;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SearchFlightDto {
    @Enumerated(value = EnumType.STRING)
    private City fromCity;
    @Enumerated(value = EnumType.STRING)
    private City toCity;
    private LocalDate journeyDate;
}
