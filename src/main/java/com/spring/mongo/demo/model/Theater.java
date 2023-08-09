package com.spring.mongo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater{
    public String theaterid;
    public String name;
    public String address;
    public String seatingcapacity;
    public List<Timings> showtimings;

}