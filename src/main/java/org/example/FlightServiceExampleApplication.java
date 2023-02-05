package org.example;

import org.example.dto.FlightBookingAcknowledgement;
import org.example.dto.FlightBookingRequest;
import org.example.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FlightServiceExampleApplication {
    @Autowired
    private FlightBookingService service;
    @PostMapping("/BookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }
    public static void main(String[] args) {
        SpringApplication.run(FlightServiceExampleApplication.class,args);
    }
}