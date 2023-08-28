package com.example.MakeYourTrip.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Entity
@Table(name = "Tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String routeDetails;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private Integer totalCostPaid;
    private String allSeatNos;

    @OneToOne
    @JoinColumn
    private Booking booking;
}
