package org.example.utils;

import org.example.exception.InsufficientAmountException;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String ,Double> paymentmap=new HashMap<>();
    {
        paymentmap.put("acc1",1200.0);
        paymentmap.put("acc1",1800.0);
        paymentmap.put("acc1",100.0);
        paymentmap.put("acc1",2800.0);
    }
    public static boolean validateCreditLimit(String accNo,double paidAmount) {
        if (paidAmount > paymentmap.get(accNo)) {
        throw new InsufficientAmountException("insufficient fund..!");
        } else {
            return true;
        }
    }
}
