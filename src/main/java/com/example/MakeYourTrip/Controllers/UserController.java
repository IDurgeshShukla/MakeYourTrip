package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDtos.BookingRequest;
import com.example.MakeYourTrip.RequestDtos.CancelTicketDto;
import com.example.MakeYourTrip.ResponseDto.ResponseCancelTicket;
import com.example.MakeYourTrip.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("find-dis-user-booked-at-least-two-tickets")
    public ResponseEntity<Integer> findDistinctUsers(){
        try {
            int ans = userService.findDistinctUsers();
            return new ResponseEntity<>(ans,HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("cancelTicket-with-transportid")
    public ResponseEntity<ResponseCancelTicket> cancelTicketByTransportId(@RequestBody CancelTicketDto cancelTicketDto){
        try {
            ResponseCancelTicket responseCancelTicket=
                    userService.cancelTicketByTransportId(cancelTicketDto);
            return new ResponseEntity<>(responseCancelTicket,HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("book_tickets")
    public ResponseEntity<String > book_Tickets(@RequestBody BookingRequest bookingRequest){
        try {
            userService.bookTickets(bookingRequest);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
