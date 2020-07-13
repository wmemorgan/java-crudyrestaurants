package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Payment;
import com.lambdaschool.crudyrestaurants.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentrepos;

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentrepos.save(payment);
    }
}
