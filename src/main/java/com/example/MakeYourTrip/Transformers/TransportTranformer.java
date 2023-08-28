package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.ResponseDto.FlightResultDto;
import com.example.MakeYourTrip.RequestDtos.AddTransportDto;

public class TransportTranformer {
    public static Transport convertToEntity(AddTransportDto addTransportDto){
        Transport transport =
                Transport.builder().modeOfTransport(addTransportDto.getModeOfTransport()).journeyDate(addTransportDto.getJourneyDate())
                        .companyName(addTransportDto.getCompanyName()).journeyTime(addTransportDto.getJourneyTime()).startTime(addTransportDto.getStartTime()).build();
        return transport;
    }
   public static FlightResultDto convertFlightEntityToResponseDto( Transport transport){
        FlightResultDto flightResultDto =
                FlightResultDto.builder().journeyDate(transport.getJourneyDate()).companyName(transport.getCompanyName())
                        .journeyTime(transport.getJourneyTime()).startTime(transport.getStartTime()).build();
        return flightResultDto;
   }

}
