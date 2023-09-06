package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDtos.AddFlightSeatDto;
import com.example.MakeYourTrip.Services.SeatService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    SeatService seatService;
    @PostMapping("/addFlightSeats")
    public ResponseEntity<String> addFlightSeats(@RequestBody AddFlightSeatDto addFlightSeatDto){
        try {
            String re = seatService.addFlightSeats(addFlightSeatDto);
            return new ResponseEntity<>(re, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
