package com.example.MakeYourTrip.RequestDtos;

import com.example.MakeYourTrip.Enums.ModeOfTransport;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTransportDto {
    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private Integer routeId;
    private String companyName;
}
