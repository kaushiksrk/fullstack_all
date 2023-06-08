package com.cgi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
	Optional<Movies> findById(String id);
	Optional<Movies> findByMovieId(String movieId);
	
	@Transactional
	Optional<List<Movies>> deleteByMovieId(String movieId);
}
