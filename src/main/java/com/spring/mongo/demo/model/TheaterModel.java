package com.spring.mongo.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookmyshow.Movie")
public class TheaterModel {

	public String name;
	public String genre;
	public String language;
	public String description;
	public List<Theater> theaters;


}
