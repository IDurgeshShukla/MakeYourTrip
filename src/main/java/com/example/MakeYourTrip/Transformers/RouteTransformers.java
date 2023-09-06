package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.RequestDtos.AddRouteDto;

public class RouteTransformers {
    public static Routes convertDtoToEntity(AddRouteDto addRouteDto){

        Routes routeObject = Routes.builder().
                fromCity(addRouteDto.getFromCity())
                .toCity(addRouteDto.getToCity())
                .listOfStopInBetween(addRouteDto.getStopsInBetween())
                .modeOfTransport(addRouteDto.getModeOfTransport())
                .build();
        return routeObject;

    }

}
