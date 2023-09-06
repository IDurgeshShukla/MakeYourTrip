package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Models.*;
import com.example.MakeYourTrip.Repositories.BookingRepository;
import com.example.MakeYourTrip.Repositories.SeatRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.RequestDtos.BookingRequest;
import com.example.MakeYourTrip.RequestDtos.CancelTicketDto;
import com.example.MakeYourTrip.ResponseDto.ResponseCancelTicket;
import com.example.MakeYourTrip.Transformers.BookingTransformer;
import com.example.MakeYourTrip.Transformers.TicketTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    BookingRepository bookingRepository;
    public int findDistinctUsers()throws Exception{
        List<Transport> transportList = transportRepository.findAll();
        Set<User> set = new HashSet<>();
        for (Transport transport : transportList){
            List<Booking> bookingList = transport.getBookings();
            for (Booking booking : bookingList){
               int seats =  booking.getSeatNos().length()/2;
               if (seats >= 2){
                   set.add(booking.getUser());
               }
            }
        }
        if (set.size() == 0) throw new Exception("Peoples booked more than 2 tickets not found");
        return set.size();
    }

    public ResponseCancelTicket cancelTicketByTransportId(CancelTicketDto cancelTicketDto)throws  Exception {
        int transportId = cancelTicketDto.getTransportId();
        String seatNo = cancelTicketDto.getSeatNo();
        Optional<Transport> OptionalTransport = transportRepository.findById(transportId);
        if (OptionalTransport.isEmpty()) throw new Exception("Transport is not present");
        Transport transport = OptionalTransport.get();
        List<Booking> bookingList = transport.getBookings();

        int costPaidforTicket = 0;
        int userId = 0;
        for (Booking booking :
                bookingList) {
            TicketEntity ticketEntity = booking.getTicketEntity();

            String seatNoArr[] = ticketEntity.getAllSeatNos().split(",");
            StringBuilder updateSeatNos = new StringBuilder();
            for (String seatNos :
                    seatNoArr) {
                if (!seatNos.equals(seatNo)) {
                    updateSeatNos.append(seatNos);
                }
                userId = booking.getUser().getUserId();
                costPaidforTicket = (ticketEntity.getTotalCostPaid() - ticketEntity.getTotalCostPaid()/seatNoArr.length);
                ticketEntity.setAllSeatNos(String.valueOf(updateSeatNos));

            }
        }
        Seat seat = seatRepository.findByTransport(transport);
        seat.setIsBooked(false);
        seatRepository.save(seat);
        transportRepository.save(transport);
        return TicketTransformer.convertToCancelTicketDto(userId,
                costPaidforTicket);
    }
    public void bookTickets(BookingRequest bookingRequest)throws  Exception {
       Booking booking = BookingTransformer.convertRequestToEntity(bookingRequest);
       bookingRepository.save(booking);
    }
}
