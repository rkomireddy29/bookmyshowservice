package com.spring.mongo.demo.service;

import com.spring.mongo.demo.model.TheaterModel;
import com.spring.mongo.demo.repository.TheaterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService{

    private static final Logger logger = LoggerFactory.getLogger(TheaterServiceImpl.class);
    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public TheaterModel getMovieTheatersByMovieName(String movieName) {
        return theaterRepository.findByName(movieName);
    }
}
