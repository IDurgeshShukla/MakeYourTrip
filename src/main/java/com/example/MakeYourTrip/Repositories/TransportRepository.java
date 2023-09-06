package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {
    @Query(value = "select * from transport where fromCity =: fromCity and toCity =: toCity",nativeQuery = true)
    List<Transport> findTransports(String fromCity, String toCity);

    @Query(value = "select * from transport where companyname =: companyname",nativeQuery = true)
    List<Transport> findTransportsWithGivenCompanyName(String companyname);
}
