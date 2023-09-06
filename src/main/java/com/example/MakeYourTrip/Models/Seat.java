package com.example.MakeYourTrip.Models;

import com.example.MakeYourTrip.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Seat {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer seatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Integer price;
    private Boolean isBooked = false;
    @ManyToOne
    @JoinColumn
    private Transport transport;
}
