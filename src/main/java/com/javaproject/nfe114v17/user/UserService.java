package com.javaproject.nfe114v17.user;

import com.javaproject.nfe114v17.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
