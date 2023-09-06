package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDtos.AddTransportDto;
import com.example.MakeYourTrip.RequestDtos.SearchFlightDto;
import com.example.MakeYourTrip.ResponseDto.FlightResultDto;
import com.example.MakeYourTrip.Services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/transport")
public class TransportController {
    @Autowired
    private TransportService transportService;

    @PostMapping("/add")

    public ResponseEntity<String> addTransport(@RequestBody AddTransportDto addTransportDto){
        try{
            String transport = transportService.addTransport( addTransportDto);
            return new ResponseEntity<>(transport + " added successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Failed : {}" + e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping("/searchFlight")
    public ResponseEntity<List<FlightResultDto>> searchFlightS( @RequestBody SearchFlightDto searchFlightDto){
        try{
            return transportService.searchFlight( searchFlightDto);
        } catch (Exception e){
            return new ResponseEntity<>( new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("find-cheapest-transportId-with-given-fromCity-toCity")
    public ResponseEntity<Integer> findTransportIdOfCheapestFlight(@RequestParam ("fromCity") String fromCity,
                                                                   @RequestParam ("toCity")
                                                                   String toCity){
        try{
            int ans = transportService.findCheapestTransportIdWithGivenAttributes(fromCity,toCity);
            return new ResponseEntity<>(ans,HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


}
