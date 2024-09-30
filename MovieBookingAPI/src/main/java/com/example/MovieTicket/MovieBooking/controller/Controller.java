package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class Controller {
	@Autowired
	MovieService movieService;
	@PostMapping("/movie")
	public void addMovie(@Valid @RequestBody Movie movie,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RuntimeException();
		}
		movieService.addMovie(movie);
	}
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return movieService.getMovieById(id);
	}
	@DeleteMapping("/movie/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieService.deleteMovie(id);
	}
	@PutMapping("/update/{id}")
	public void updateMovie(@Valid @RequestBody Movie movie,@PathVariable String id) {
		movieService.updateMovie(movie,id);
	}
}
