package com.kumar.jpaexample.utils;

import com.kumar.jpaexample.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private  static final Map<String, Double> paymentMap = new HashMap<>();

    {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 5000.0);
        paymentMap.put("acc4", 8000.0);
    }

    public  static  boolean validateCreditLimit(String accNo, double paidAmount){
        if (paidAmount > paymentMap.getOrDefault(accNo,10000.0)){
            throw  new InsufficientAmountException("insufficient fund ...");
        }else {
            return  true;
        }
    }
}
