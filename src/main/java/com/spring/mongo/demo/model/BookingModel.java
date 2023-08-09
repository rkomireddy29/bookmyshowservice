package com.spring.mongo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookmyshow.bookings")
public class BookingModel {

    public String moviename;
    public String date;
    public String theaterid;
    public String showid;
    public String rowid;
    public String columnid;
    public String personname;
    public String personage;
}
