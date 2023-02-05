package org.example.repository;

import org.example.entity.PassengerInfo;
import org.example.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
