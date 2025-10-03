package com.careNet.carenet.demo.controller;

import com.careNet.carenet.demo.entity.Booking;
import com.careNet.carenet.demo.entity.Payment;
import com.careNet.carenet.demo.repository.BookingRepository;
import com.careNet.carenet.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Create a new payment
    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment paymentRequest) {
        try {
            // fetch booking
            Booking booking = bookingRepository.findById(paymentRequest.getBooking().getBookingID())
                    .orElseThrow(() -> new RuntimeException("Booking not found"));

            // create payment
            Payment payment = new Payment();
            payment.setBooking(booking);
            payment.setCardNumber(paymentRequest.getCardNumber()); // for real apps, only last 4 digits
            payment.setCardHolderName(paymentRequest.getCardHolderName());
            payment.setExpiry(paymentRequest.getExpiry());
            payment.setAmount(paymentRequest.getAmount());
            payment.setPaymentStatus("SUCCESS"); // just mock success
            payment.setPaymentDate(LocalDateTime.now());
            payment.setTransactionId("TXN" + System.currentTimeMillis());

            Payment savedPayment = paymentRepository.save(payment);
            return ResponseEntity.ok(savedPayment);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Payment failed: " + e.getMessage());
        }
    }

    // Optional: get payment by booking
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<?> getPaymentByBooking(@PathVariable Long bookingId) {
        Payment payment = paymentRepository.findByBooking_BookingID(bookingId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.status(404).body("Payment not found");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(paymentRepository.findAll());
    }

}
