package com.careNet.carenet.demo.repository;

import com.careNet.carenet.demo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // You can add custom queries here if needed, e.g.,
    // List<Booking> findByCaregiverId(Long caregiverId);
}
