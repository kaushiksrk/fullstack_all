package com.cgi.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.dto.ErrorTO;
import com.cgi.dto.MoviesTO;
import com.cgi.model.Movies;
import com.cgi.services.MovieService;

@RestController
@RequestMapping("/in")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorTO> handleException(Exception e) {
		ErrorTO errorTO=new ErrorTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis(), LocalDate.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorTO);
	}
	
	@PostMapping("/create-movie") // http://localhost:9090/movies/in/create-movie
	public ResponseEntity<Movies> createStudent(@RequestBody MoviesTO moviesTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createStudent(moviesTO));
	}
	
	@GetMapping("/all-movies") // http://localhost:9090/movies/in/all-movies
	public ResponseEntity<Collection<MoviesTO>> listStudents() {
		return ResponseEntity.ok().body(movieService.getAllMovies());
	}
	
	@GetMapping("/{movieId}") // http://localhost:9090/movies/in/{movieId}
	public ResponseEntity<MoviesTO> getMovieByMovieId(@PathVariable("movieId") String movieId) {
		return ResponseEntity.ok().body(movieService.findByMovieId(movieId));
	}

	@DeleteMapping("/delete-movie/{movieId}") // http://localhost:9090/movies/in/delete-movie/{movieId}
	public ResponseEntity<List<MoviesTO>> createStudent(@PathVariable("movieId") String movieId) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.deleteByMovieId(movieId));
	}
	
	@PutMapping("/update-movie") // http://localhost:9090/movies/in/update-movie
	public ResponseEntity<?> updateMovieByMovieId(@RequestBody MoviesTO moviesTO) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.updateByMovieId(moviesTO));
	}
}
