package com.example.MakeYourTrip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String  name;
    private String emailId;
    private Integer age;

    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
    private List<Booking> bookingList = new ArrayList<>();

}
