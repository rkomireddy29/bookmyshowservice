package com.spring.mongo.demo.repository;
import com.spring.mongo.demo.model.TheaterModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends MongoRepository<TheaterModel,String> {
    TheaterModel findByName(String name);
}