package com.example.MakeYourTrip.RequestDtos;

import lombok.Data;

@Data
public class CancelTicketDto {
    private Integer transportId;
    private String seatNo;
}
