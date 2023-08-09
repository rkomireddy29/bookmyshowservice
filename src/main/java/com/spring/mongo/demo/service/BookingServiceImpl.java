package com.spring.mongo.demo.service;

import com.spring.mongo.demo.model.*;
import com.spring.mongo.demo.repository.BookingRepository;
import com.spring.mongo.demo.repository.TheaterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TheaterRepository theaterRepository;


    @Override
    public BookingDetails getBookingDetails(String theaterId, String date, String showId){
        BookingDetails bookingDetails = new BookingDetails();
        List<BookedSeats> bookedSeats = new ArrayList<BookedSeats>();
        List<BookingModel> bookingModelList =  bookingRepository.getBookingDetails(theaterId,date,showId);
        int numberOfSeatsBooked = 0;
        int totalSeats = 0;
        String numberofseatsavailable = null;
        String movieName = null;

        if(null != bookingModelList && bookingModelList.size()>0){
            numberOfSeatsBooked = bookingModelList.size();
            BookingModel bookingModel = bookingModelList.get(0);
            movieName =bookingModel.moviename;
            TheaterModel theaterModel = theaterRepository.findByName(movieName);
            List<Theater> theaterList = theaterModel.theaters;
            for(Theater theater : theaterList){
                if(theater.theaterid.equals(theaterId)){
                    totalSeats = Integer.parseInt(theater.seatingcapacity);
                    break;
                }
            }

            if(numberOfSeatsBooked < totalSeats){
                bookingDetails.seatsAvailable = true;
                numberofseatsavailable = ""+(totalSeats - numberOfSeatsBooked);
                bookingDetails.numberofseatsavailable = numberofseatsavailable;
            }else{
                bookingDetails.seatsAvailable = false;
            }
            for(BookingModel bookingModelObj : bookingModelList){
                BookedSeats seat = new BookedSeats();
                seat.columnid = bookingModelObj.columnid;
                seat.rowid = bookingModelObj.rowid;
                bookedSeats.add(seat);
            }
        }else{
            logger.debug("No seat booked yet");
            bookingDetails.seatsAvailable = true;
            bookingDetails.numberofseatsavailable = "All";
        }

        bookingDetails.bookedSeats = bookedSeats;

        return bookingDetails;
    }

    @Override
    public void save(BookingModel bookingModel){
        bookingRepository.save(bookingModel);
    }
}
