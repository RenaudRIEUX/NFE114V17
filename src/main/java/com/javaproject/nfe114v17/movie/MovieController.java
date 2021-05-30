package com.javaproject.nfe114v17.movie;

import com.javaproject.nfe114v17.tmdbApi.NotFoundException;
import com.javaproject.nfe114v17.tmdbApi.TmdbApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieService movieService;
    private final TmdbApiClient tmdbApiClient;

    @Autowired
    public MovieController(MovieService movieService, TmdbApiClient tmdbApiClient) {
        this.movieService = movieService;
        this.tmdbApiClient = tmdbApiClient;
    }

//    @GetMapping
//    public List<Movie> getMovie() {
//        return movieService.getMovie();
//    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) throws IOException, InterruptedException {
        try {
            Movie movieById = tmdbApiClient.getMovieById(movieId);
            return new ResponseEntity<>(movieById, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchMovie(@RequestParam String query) throws IOException, InterruptedException{
        try {
            return new ResponseEntity<> (tmdbApiClient.searchMovie(query),  HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping(path = "/delete/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieService.deleteMovie(movieId);
    }

}
