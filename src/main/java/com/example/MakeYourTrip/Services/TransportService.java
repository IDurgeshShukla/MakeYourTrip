package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Enums.ModeOfTransport;
import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.Repositories.RouteRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.RequestDtos.AddTransportDto;
import com.example.MakeYourTrip.RequestDtos.SearchFlightDto;
import com.example.MakeYourTrip.ResponseDto.FlightResultDto;
import com.example.MakeYourTrip.Transformers.TransportTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {
    @Autowired
    TransportRepository transportRepository;
    @Autowired
    RouteRepository routeRepository;
    public String addTransport(AddTransportDto addTransportDto) throws  Exception{
        Transport transport = TransportTranformer.convertToEntity(addTransportDto);
        Optional<Routes> routesOptional = routeRepository.findById(transport.getRoute().getRouteId());
        transportRepository.save(transport);
        return transport.getModeOfTransport().toString();
    }

    public ResponseEntity<List<FlightResultDto>> searchFlight(SearchFlightDto searchFlightDto)throws  Exception {

       List<FlightResultDto> ans = new ArrayList<>();
       List<Routes> routesList =
               routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightDto.getFromCity(),
                       searchFlightDto.getToCity(),ModeOfTransport.Flight);
        for (Routes routes : routesList ) {
            List<Transport> transportList = routes.getTransportList();
            for (Transport transport :
                    transportList) {
                if (transport.getJourneyDate().equals(searchFlightDto.getJourneyDate())){
                    FlightResultDto resultDto = TransportTranformer.convertFlightEntityToResponseDto(transport);
                    resultDto.setListOfStopInBetween(routes.getListOfStopInBetween());
                    ans.add(resultDto);
                }
            }
        }
        return new ResponseEntity<>(ans, HttpStatus.FOUND);
    }
}
