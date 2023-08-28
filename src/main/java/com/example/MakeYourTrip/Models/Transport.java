package com.example.MakeYourTrip.Models;

import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    private Integer transportId;
    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private String companyName;
    @ManyToOne
    @JoinColumn
    private Routes route;
    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
}
