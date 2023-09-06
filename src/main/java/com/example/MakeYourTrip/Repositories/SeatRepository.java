package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Seat;
import com.example.MakeYourTrip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {


    Seat findByTransport(Transport transport);
}
