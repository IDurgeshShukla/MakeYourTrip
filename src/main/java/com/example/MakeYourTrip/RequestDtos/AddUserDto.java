package com.example.MakeYourTrip.RequestDtos;

import lombok.Data;

@Data
public class AddUserDto{
    private String name;
    private String emailId;
    private Integer age;
}
