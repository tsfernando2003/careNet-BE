package com.careNet.carenet.demo.entity;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;

    private String date;  // could also use LocalDate if you want
    private String time;  // could also use LocalTime
    private Long caregiverId;
    private int duration; // in hours
    private String specialInstructions;

    // Constructors
    public Booking() {}

    public Booking(String date, String time, Long caregiverId, int duration, String specialInstructions) {
        this.date = date;
        this.time = time;
        this.caregiverId = caregiverId;
        this.duration = duration;
        this.specialInstructions = specialInstructions;
    }

    // Getters & Setters
    public Long getBookingID() { return bookingID; }
    public void setBookingID(Long bookingID) { this.bookingID = bookingID; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public Long getCaregiverId() { return caregiverId; }
    public void setCaregiverId(Long caregiverId) { this.caregiverId = caregiverId; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getSpecialInstructions() { return specialInstructions; }
    public void setSpecialInstructions(String specialInstructions) { this.specialInstructions = specialInstructions; }
}
