package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
