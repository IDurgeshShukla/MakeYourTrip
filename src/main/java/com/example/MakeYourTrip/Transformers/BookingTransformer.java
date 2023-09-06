package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Booking;
import com.example.MakeYourTrip.RequestDtos.BookingRequest;

public class BookingTransformer {
    public static Booking convertRequestToEntity(BookingRequest bookingRequest){
        return Booking.builder().journeyDate(bookingRequest.getJourneyDate()).seatNos(bookingRequest.getSeatNos()).build();

    }
}
