package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import com.example.MovieTicket.MovieBooking.Model.Movie;

public interface MovieServiceInterface {
	public void addMovie(Movie movie);
	public List<Movie> getAllMovies();
	public Movie getMovieById(String id);
	public void deleteMovie(String id);
	public void updateMovie(Movie movie, String id);
}
