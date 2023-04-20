package com.kumar.jpaexample.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "PAYMENT_INFO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentInfo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private  String paymentId;
    private String accountNo;
    private double amount;
    private String cardType;
    private Long passengerId;
}
