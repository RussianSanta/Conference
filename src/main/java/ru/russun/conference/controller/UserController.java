package ru.russun.conference.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.russun.conference.dto.UserDto;
import ru.russun.conference.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{user-id}")
    public UserDto getUserById(@PathVariable("user-id") Integer id) {
        return userService.getUser(id);
    }
}
