package org.example.service;

import org.example.dto.FlightBookingAcknowledgement;
import org.example.dto.FlightBookingRequest;
import org.example.entity.PassengerInfo;
import org.example.entity.PaymentInfo;
import org.example.repository.PassengerInfoRepository;
import org.example.repository.PaymentInfoRepository;
import org.example.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.UUID;

@Service
public class FlightBookingService{
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Transactional//(readOnly= false,isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        FlightBookingAcknowledgement acknowledgement=null;
        PassengerInfo passengerInfo=request.getPassengerInfo();
        passengerInfo=passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo=request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("sucess",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}