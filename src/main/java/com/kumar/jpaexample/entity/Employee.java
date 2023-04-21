package com.kumar.jpaexample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue
    private  Long empId;
    private String name;
    private Integer age;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber = "9999999999";
    private String designation;
    private Double salary= Math.random()*100000;
}
