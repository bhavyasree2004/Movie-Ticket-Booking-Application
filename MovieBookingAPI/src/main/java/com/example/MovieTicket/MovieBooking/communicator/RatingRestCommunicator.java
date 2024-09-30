package com.example.MovieTicket.MovieBooking.communicator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingRestCommunicator {
	private final RestTemplate restTemplate;

	@Autowired
	public RatingRestCommunicator(RestTemplateBuilder restTemplatebuilder) {
		this.restTemplate = restTemplatebuilder.build();
	}
	String url= "http://localhost:8081/rating/";
	public void addRating(Map<String, Long> newMovie) {
		// TODO Auto-generated method stub
		restTemplate.postForEntity(url+"/add", newMovie, Object.class);
	}

	public long getRating(String id) {
		// TODO Auto-generated method stub
		ResponseEntity<Long> response=restTemplate.getForEntity(url+"id/"+id, Long.class);
		return response.getBody();
	}

	public void deleteRating(String id) {
		// TODO Auto-generated method stub
		restTemplate.exchange(url+"id/"+id, HttpMethod.DELETE, null, Object.class);
	}

	public void updateRating(Map<String, Long> updatedMovie) {
		// TODO Auto-generated method stub
		HttpEntity<Map<String,Long>> updated=new HttpEntity<Map<String,Long>>(updatedMovie);
		restTemplate.exchange(url+"update", HttpMethod.PUT, updated, Object.class);	
	}
	
	
	
}
