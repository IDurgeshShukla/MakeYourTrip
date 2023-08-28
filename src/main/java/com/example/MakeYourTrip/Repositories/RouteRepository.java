package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeOfTransport;
import com.example.MakeYourTrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Routes, Integer> {
    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport flight);
}
