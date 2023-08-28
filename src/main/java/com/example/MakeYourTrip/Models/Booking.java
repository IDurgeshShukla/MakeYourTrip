package com.example.MakeYourTrip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
// this will keep record whether seat is available or is booked already for a person
public class Booking {
    @Id
    private Integer bookingId;

    private Date journeyDate;
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
