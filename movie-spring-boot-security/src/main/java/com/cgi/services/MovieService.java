package com.cgi.services;

import java.util.List;

import com.cgi.dto.MoviesTO;
import com.cgi.model.Movies;

public interface MovieService {
	public Movies createStudent(MoviesTO movies);
	public List<MoviesTO> getAllMovies();
	public MoviesTO findByMovieId(String movieId);
	public List<MoviesTO> deleteByMovieId(String movieId);
	public Movies updateByMovieId(MoviesTO moviesTo);
}
