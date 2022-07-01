package com.techelevator.reservations.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Reservation {

    @Min(value = 1, message = "id must be greater than 0")
    private int id;

    @Min(value = 1, message = "hotelID must be greater than 0")
    private int hotelID;

    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @FutureOrPresent
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate checkinDate;

    @NotNull
    @FutureOrPresent
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate checkoutDate;

    @AssertTrue(message = "Check in date must come prior to Check out date")
    private boolean isCheckoutDateAfterOrEqualToCheckInDate() {
        if(checkinDate == null || checkoutDate == null) return false;

        return checkoutDate.compareTo(checkinDate) >= 0;
    }

    @AssertTrue(message = "Length of stay must be less than 6 days")
    private boolean isLengthOfStayLessThan6Days() {
        if(checkinDate == null || checkoutDate == null) return false;

        return checkoutDate.minusDays(6).compareTo(checkinDate) >= 0;
    }

    @Min(value = 1, message = "guests must be greater than 0")
    @Max(value = 5, message = "guests must be less than 6")
    private int guests;

    public Reservation(int id, int hotelID, String fullName, LocalDate checkinDate, LocalDate checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelID
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
