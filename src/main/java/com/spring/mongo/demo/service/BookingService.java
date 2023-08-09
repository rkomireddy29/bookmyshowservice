package com.spring.mongo.demo.service;


import com.spring.mongo.demo.model.BookingDetails;
import com.spring.mongo.demo.model.BookingModel;

public interface BookingService {

    // get the theater list along with movie details
    BookingDetails getBookingDetails(String theaterid, String date, String showid);

    void save(BookingModel bookingModel);

}
