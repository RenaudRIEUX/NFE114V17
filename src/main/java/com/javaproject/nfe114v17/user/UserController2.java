package com.javaproject.nfe114v17.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController2 {

    private final UserService userService;

    @Autowired
    public UserController2(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable String userId, Model model) {
        Integer parsedUserId = Integer.parseInt(userId);
        User user = userService.getUserById(parsedUserId);
        model.addAttribute(user);
        return "user";
    }
}
