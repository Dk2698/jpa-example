package com.kumar.jpaexample;

import com.kumar.jpaexample.dto.FlightBookingAcknowledgement;
import com.kumar.jpaexample.dto.FlightBookingRequest;
import com.kumar.jpaexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JpaExampleApplication {

	@Autowired
	private FlightBookingService service;


	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}


	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

}
