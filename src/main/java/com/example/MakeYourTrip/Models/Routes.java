package com.example.MakeYourTrip.Models;

import com.example.MakeYourTrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.MakeYourTrip.Enums.City;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;
    @Enumerated(value = EnumType.STRING)
    private City fromCity;
    @Enumerated(value = EnumType.STRING)
    private City toCity;

    private String listOfStopInBetween;
    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    @OneToMany(mappedBy = "route", cascade =  CascadeType.ALL)
    private List<Transport> transportList = new ArrayList<>();

}