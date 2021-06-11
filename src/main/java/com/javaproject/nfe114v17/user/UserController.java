package com.javaproject.nfe114v17.user;

import com.javaproject.nfe114v17.tmdbApi.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable String userId, Model model) {
        Integer parsedUserId = Integer.parseInt(userId);
        User user = userService.getUserById(parsedUserId);
        model.addAttribute(user);
        System.out.println(user.getUserId());
        System.out.println(user.getSeenMovies());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        model.addAttribute("currentUser", currentUser);


        return "user";
    }

    @RequestMapping(value = "user/{userId}/statistics", method = RequestMethod.GET)
    public String getStatistics(@PathVariable String userId, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        model.addAttribute("currentUser", currentUser);


        Integer parsedUserId = Integer.parseInt(userId);
        User user = userService.getUserById(parsedUserId);
        int timeSpentWatching = userService.getTimeSpentWatching(user);
        int favoriteRealeasedYear = userService.getFavoriteRealeasedYear(user);
        model.addAttribute("timeSpentWatching", timeSpentWatching);
        model.addAttribute("favoriteRealeasedYear", favoriteRealeasedYear);
        return "statistics";
    }

    @PostMapping(path = "user/{userName}/movie/{movieId}")
    public String addSeenMovie(@PathVariable String userName, @PathVariable int movieId) throws NotFoundException, IOException, InterruptedException {
        userService.addSeenMovie(userName, movieId);

        return "redirect:/";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        model.addAttribute("currentUser", currentUser);


        return "register";
    }

    @RequestMapping(path = "/registration_complete", method = RequestMethod.POST)
    public String processRegistration(User user){
        userService.processRegistration(user);
        return "redirect:/";
    }


}

