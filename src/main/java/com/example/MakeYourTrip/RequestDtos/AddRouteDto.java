package com.example.MakeYourTrip.RequestDtos;

import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeOfTransport;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AddRouteDto {
    @Enumerated(value = EnumType.STRING)
    private City fromCity;
    @Enumerated(value = EnumType.STRING)
    private City toCity;
    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    private String StopsInBetween;

}
