package com.javaproject.nfe114v17.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

//    public Movie getMovieById(int movieId) {
//        Optional<Movie> optMovie = movieRepository.findByMovieId(movieId);
//        boolean exists=  movieRepository.existsById(movieId);
//        if (!exists){
//            throw new IllegalStateException("Movie with id +" + movieId + " does not exists");
//        }
//        return optMovie.get();
//    }

    public Movie getMovieById(int movieId) throws IOException, InterruptedException{
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=c58ffbbfcec3d00f132dc417fb260fb0";

        HttpClient client = HttpClient.newHttpClient() ;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        Movie movie = mapper.readValue(response.body(), Movie.class);
        return movie;
    }



    @PostMapping
    public void addNewMovie(Movie movie) {

        Optional<Movie> movieByTitle = movieRepository.findByTitle(movie.getTitle());
        if (movieByTitle.isPresent()){
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
