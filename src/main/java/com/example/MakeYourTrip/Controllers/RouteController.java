package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDtos.AddRouteDto;
import com.example.MakeYourTrip.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;
    @PostMapping("/add")
    public ResponseEntity<String > addRoute( @RequestBody AddRouteDto addrouteDto){
        try {
            String result = routeService.addRoute(addrouteDto);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
