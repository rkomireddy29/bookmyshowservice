package com.spring.mongo.demo.service;


import com.spring.mongo.demo.model.TheaterModel;

public interface TheaterService {

    // get the theater list along with movie details
    TheaterModel getMovieTheatersByMovieName(String movieName);

}
