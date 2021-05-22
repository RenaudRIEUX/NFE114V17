package com.javaproject.nfe114v17.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }


    @PostMapping
    public void addNewMovie(Movie movie) {

        Optional<Movie> movieByEmail = movieRepository.findByTitle(movie.getTitle());
        if (movieByEmail.isPresent()){
            throw new IllegalStateException("movie taken");
        }
        movieRepository.save(movie);

    }

    public void deleteMovie(int movieId){
        boolean exists=  movieRepository.existsById(movieId);
        if (!exists){
            throw new IllegalStateException("Movie with id +" + movieId + " does not exists");
        }
        movieRepository.deleteById(movieId);
    }


}
