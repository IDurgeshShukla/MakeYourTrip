package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.Repositories.RouteRepository;
import com.example.MakeYourTrip.RequestDtos.AddRouteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    public String addRoute(AddRouteDto addrouteDto){
        Routes routes =
                Routes.builder().fromCity(addrouteDto.getFromCity()).toCity(addrouteDto.getToCity()).modeOfTransport(addrouteDto.getModeOfTransport()).build();

        routeRepository.save(routes);
        return "route saved Successfully";
    }

}
