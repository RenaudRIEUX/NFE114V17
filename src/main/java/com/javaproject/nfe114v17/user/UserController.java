package com.javaproject.nfe114v17.user;

import com.javaproject.nfe114v17.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/allusers")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public void addMovie(@RequestBody User user) {
        userService.addNewUser(user);
    }
}





