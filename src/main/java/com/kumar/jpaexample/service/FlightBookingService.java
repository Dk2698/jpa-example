package com.kumar.jpaexample.service;

import com.kumar.jpaexample.dto.FlightBookingAcknowledgement;
import com.kumar.jpaexample.dto.FlightBookingRequest;
import com.kumar.jpaexample.entity.PassengerInfo;
import com.kumar.jpaexample.entity.PaymentInfo;
import com.kumar.jpaexample.repository.PassengerInfoRepository;
import com.kumar.jpaexample.repository.PaymentInfoRepository;
import com.kumar.jpaexample.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository  paymentInfoRepository;

    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){

        PassengerInfo  passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        return  new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}
