package com.example.MakeYourTrip.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
// this will keep record whether seat is available or is booked already for a person
public class Booking {
    @Id
    private Integer bookingId;

    private LocalDate journeyDate;
    private String seatNos; // comma seperated value
    private Integer transportId;
    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking", cascade =  CascadeType.ALL)
    private TicketEntity ticketEntity;
    @ManyToOne
    @JoinColumn
    private User user;
}
