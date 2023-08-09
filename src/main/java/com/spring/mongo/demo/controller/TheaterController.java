package com.spring.mongo.demo.controller;

import com.spring.mongo.demo.model.BookingDetails;
import com.spring.mongo.demo.model.BookingModel;
import com.spring.mongo.demo.model.TheaterModel;
import com.spring.mongo.demo.service.BookingService;
import com.spring.mongo.demo.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmyshow")
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	@Autowired
	BookingService bookingService;
		
		
	@RequestMapping(value = "/theater-list/{movieName}")
	public TheaterModel getTheaterList(@PathVariable String movieName) {
		TheaterModel theaterModel = theaterService.getMovieTheatersByMovieName(movieName);
		return theaterModel;
	}

	@PostMapping("/book-tickets")
	public ResponseEntity<?> bookTickets(@RequestBody BookingModel bookingModel) {
		bookingService.save(bookingModel);
		return ResponseEntity.ok("Your tickets were booked successfully!");
	}

	@RequestMapping(value = "/booking-details/{theaterid}/{date}/{showid}")
	public BookingDetails getBookingDetails(@PathVariable String theaterid, @PathVariable String date, @PathVariable String showid) {
		BookingDetails bookingDetails = bookingService.getBookingDetails(theaterid,date,showid);
		return bookingDetails;
	}


}
