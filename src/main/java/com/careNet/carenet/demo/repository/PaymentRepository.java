package com.careNet.carenet.demo.repository;

import com.careNet.carenet.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Optional: find payment by booking
    Payment findByBooking_BookingID(Long bookingId);
}
