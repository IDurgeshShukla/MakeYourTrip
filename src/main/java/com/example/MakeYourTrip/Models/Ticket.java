package com.example.MakeYourTrip.Models;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

}
