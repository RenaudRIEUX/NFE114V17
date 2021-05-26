package com.javaproject.nfe114v17.user;

import com.javaproject.nfe114v17.movie.Movie;
import com.javaproject.nfe114v17.tmdbApi.NotFoundException;
import com.javaproject.nfe114v17.tmdbApi.TmdbApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TmdbApiClient tmdbApiClient;

    @Autowired
    public UserService(UserRepository userRepository, TmdbApiClient tmdbApiClient) {
        this.userRepository = userRepository;
        this.tmdbApiClient = tmdbApiClient;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        Optional<User> optUser = userRepository.findByUserId(userId);
        boolean exists=  userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id +" + userId + " does not exists");
        }
        return optUser.get();

    }

    public void addNewUser(User user) {
        Optional<User> optUser = userRepository.findByLogin(user.getLogin());

        if (optUser.isPresent()){
            throw new IllegalStateException("User with login +" + user.getLogin() + " Already exists");
        }
        userRepository.save(user);
    }

    public void addSeenMovie(int userId, int movieId) throws NotFoundException, IOException, InterruptedException {
        User user = userRepository.getOne(userId);
        Movie movie = tmdbApiClient.getMovieById(movieId);
        user.addMovie(movie);
        userRepository.save(user);


    }
}
