package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Enums.ModeOfTransport;
import com.example.MakeYourTrip.Models.*;
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

import java.time.LocalDate;
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
    public int findCheapestTransportIdWithGivenAttributes(String fromCity, String toCity) throws  Exception{
        List<Transport> transportList = transportRepository.findTransports(fromCity,toCity);
        int transportId = 0;
        int price =Integer.MAX_VALUE;
        for (Transport transport :
                transportList) {
           List<Seat> seatList = transport.getSeats();
            for (Seat seat :
                    seatList) {
                if (seat.getPrice() < price) {
                    transportId = transport.getTransportId();
                    price = seat.getPrice();
                }
            }
        }
        return transportId;
    }
    public int findRevenueInGivenMonthWithCompanyName(String companyName) throws  Exception{
        int totalRevenue = 0;
        List<Transport> transportList = transportRepository.findTransportsWithGivenCompanyName(companyName);
        LocalDate beforeDate = LocalDate.of(2023, 7,31);
        LocalDate afterDate = LocalDate.of(2023, 9,1);
        for (Transport transport :
                transportList) {
           List<Booking> bookingList = transport.getBookings();
            for (Booking booking :
                    bookingList) {
                TicketEntity ticketEntity = booking.getTicketEntity();
                if (ticketEntity.getJourneyDate().isAfter(beforeDate) && ticketEntity.getJourneyDate().isBefore(afterDate)){
                    totalRevenue += ticketEntity.getTotalCostPaid();
                }
            }
        }
        return totalRevenue;
    }
}
