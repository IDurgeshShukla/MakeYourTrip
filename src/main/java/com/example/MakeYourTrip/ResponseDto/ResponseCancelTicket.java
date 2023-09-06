package com.example.MakeYourTrip.ResponseDto;

import lombok.Data;

@Data
public class ResponseCancelTicket {
    private Integer userId;
    private Integer amount;

    public ResponseCancelTicket(Integer userId, Integer amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
