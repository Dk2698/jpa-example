package com.kumar.jpaexample.repository;

import com.kumar.jpaexample.entity.PassengerInfo;
import com.kumar.jpaexample.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
