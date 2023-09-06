package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Enums.SeatType;
import com.example.MakeYourTrip.Models.Seat;
import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.Repositories.SeatRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.RequestDtos.AddFlightSeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private SeatRepository seatRepository;

    public String addFlightSeats(AddFlightSeatDto addFlightSeatDto) {
        Transport transport = transportRepository.findById(addFlightSeatDto.getTransportId()).get();
        for(int i = 1 ; i <= addFlightSeatDto.getNoOfBusinessSeats(); i++){
            Seat seat =
                    Seat.builder().seatType(SeatType.Business).seatNo("E" + i).transport(transport).price(addFlightSeatDto.getPriceOfBusinessSeat()).build();
            transport.getSeats().add(seat);
            seatRepository.save(seat);
        }
        for(int i = 1 ; i <= addFlightSeatDto.getNoOfBusinessSeats(); i++){
            Seat seat =
                    Seat.builder().seatType(SeatType.Business).seatNo("B" + i).transport(transport).price(addFlightSeatDto.getPriceOfBusinessSeat()).build();
            transport.getSeats().add(seat);

        }
        for(int i = 1 ; i <= addFlightSeatDto.getNoOfEconomySeats(); i++){
            Seat seat =
                    Seat.builder().seatType(SeatType.Economy).seatNo("E" + i).transport(transport).price(addFlightSeatDto.getPriceOfBusinessSeat()).build();
            transport.getSeats().add(seat);
            seatRepository.save(seat);
        }
        transportRepository.save(transport);
        return "Seats added successfully";
    }
}
