package com.spring.mongo.demo.repository;
import com.spring.mongo.demo.model.BookingModel;
import com.spring.mongo.demo.model.TheaterModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<BookingModel,String> {

    @Query("{theaterid: ?0, date: ?1, showid: ?2}")
    List<BookingModel> getBookingDetails(String theaterid,String date,String showid);
}