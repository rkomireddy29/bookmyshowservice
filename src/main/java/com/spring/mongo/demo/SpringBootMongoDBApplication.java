package com.spring.mongo.demo;

import com.spring.mongo.demo.model.TheaterModel;
import com.spring.mongo.demo.repository.TheaterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongoDBApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDBApplication.class, args);
	}

	/*@Autowired
	private TheaterRepository theaterRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			TheaterModel theaterModel = theaterRepository.findByName("Movie4");
			System.out.println("Size of theaters...:" + theaterModel.getTheaters().size());
			System.out.println("Size of timings....:" + theaterModel.getTheaters().get(0).getshowTimings().size());
		};
	}*/

}
