package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExists;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;
@Service
public class MovieService {
	
	public List<Movie> movieList=new ArrayList<>();
	public Map<String,Movie> map=new HashMap<>();
	
	@Autowired
	RatingRestCommunicator ratingServiceCommunicator;
	
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		if(!(ObjectUtils.isEmpty(map.get(movie.getId())))) {
			throw new IdAlreadyExists("Id already exists");
		}
		
		movieList.add(movie);
		map.put(movie.getId(),movie);
		Map<String,Long> newMovie=new HashMap<>();
		newMovie.put(movie.getId(), movie.getMovieRating());
		ratingServiceCommunicator.addRating(newMovie);
	}
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieList;
	}
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		if(ObjectUtils.isEmpty(map.get(id))) {
			throw new IdNotFound("Not found id");
		}
		Movie movie=map.get(id);
		long updatedRating=ratingServiceCommunicator.getRating(id);
		movie.setMovieRating(updatedRating);
		return movie;
	}
	public void deleteMovie(String id) {
		// TODO Auto-generated method stub
		if(ObjectUtils.isEmpty(map.get(id))) {
			throw new IdNotFound("Not found id");
		}
		movieList.remove(map.get(id));
		map.remove(id);
		ratingServiceCommunicator.deleteRating(id);
	}
	public void updateMovie(Movie movie, String id) {
		// TODO Auto-generated method stub
		Movie oldmovie=getMovieById(id);
		movieList.remove(oldmovie);
		movieList.add(movie);
		map.put(id,movie);
		Map<String,Long> newMovie=new HashMap<>();
		newMovie.put(id, movie.getMovieRating());
		ratingServiceCommunicator.updateRating(newMovie);
		
	}
	
}
