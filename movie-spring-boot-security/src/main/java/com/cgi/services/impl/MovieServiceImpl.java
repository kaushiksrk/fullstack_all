package com.cgi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dto.MoviesTO;
import com.cgi.model.Movies;
import com.cgi.repository.MovieRepository;
import com.cgi.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Movies createStudent(MoviesTO moviesTo) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Movies movies=modelMapper.map(moviesTo, Movies.class);
		movies.setMovieId(UUID.randomUUID().toString());
		
		return movieRepository.save(movies);
	}
	
	@Override
	public List<MoviesTO> getAllMovies() {
		List<MoviesTO> moviesList=new ArrayList<>();
		
		movieRepository.findAll().stream().forEach(movie -> {
			moviesList.add(modelMapper.map(movie, MoviesTO.class));
		});
		
		return moviesList;
	}
	
	@Override
	public MoviesTO findByMovieId(String movieId) {
		return modelMapper.map(movieRepository.findByMovieId(movieId).get(), MoviesTO.class);
	}
	
	@Override
	public List<MoviesTO> deleteByMovieId(String movieId) {
		List<MoviesTO> deletedMoviesList=new ArrayList<>();
		
		movieRepository.deleteByMovieId(movieId).get().stream().forEach(movie -> {
			deletedMoviesList.add(modelMapper.map(movie, MoviesTO.class));
		});
		
		return deletedMoviesList;
	}
	
	@Override
	public Movies updateByMovieId(MoviesTO moviesTo) {
		Movies movies = movieRepository.findByMovieId(moviesTo.getMovieId()).get();
		
		if(moviesTo.getGenre()!=null) {
			movies.setGenre(moviesTo.getGenre());	
		}
		
		
		if(moviesTo.getMovieName()!=null) {
			movies.setMovieName(moviesTo.getMovieName());	
		}
		
		
		return movieRepository.save(movies);
	}
}
