package com.example.MakeYourTrip.Transformers;
import com.example.MakeYourTrip.ResponseDto.ResponseCancelTicket;

public class TicketTransformer {
    public  static ResponseCancelTicket convertToCancelTicketDto(Integer userId, Integer amount){
        return new ResponseCancelTicket(userId,amount);
    }
}
