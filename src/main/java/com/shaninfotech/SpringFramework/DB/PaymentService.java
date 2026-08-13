package com.shaninfotech.SpringFramework.DB;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void makePayment(PaymentEntity payment) {

        if (customerRepository.existById(payment.getCustomer().getCustomerId())) {
            paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Customer not found : "
                    + payment.getCustomer().getCustomerId());
        }
    }

    @Transactional(readOnly = true)
    public PaymentEntity getPayment(String transactionId) {
        return paymentRepository.findById(transactionId);
    }

    @Transactional(readOnly = true)
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<PaymentEntity> getPaymentsByCustomer(String customerId) {
        return paymentRepository.findByCustomerId(customerId);
    }

    @Transactional
    public void updatePayment(PaymentEntity payment) {
        paymentRepository.update(payment);
    }

    @Transactional
    public void removePayment(String transactionId) {
        paymentRepository.deleteById(transactionId);
    }

    @Transactional(readOnly = true)
    public long totalPayments() {
        return paymentRepository.count();
    }
}