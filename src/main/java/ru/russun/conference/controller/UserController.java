package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.UserDto;
import ru.russun.conference.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{user-id}")
    public UserDto getUserById(@PathVariable("user-id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/banned={is-banned}")
    public List<UserDto> getBannedUsers(@PathVariable("is-banned") boolean isBanned) {
        return userService.getBannedUsers(isBanned);
    }

    @PostMapping("/registration")
    public UserDto addNewUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("/users/{user-id}")
    public UserDto updateUserData(@RequestBody UserDto userDto, @PathVariable("user-id") Integer id) {
        return userService.updateUser(userDto, id);
    }

    @PutMapping("/users/{user-id}/ban")
    public UserDto banUser(@PathVariable("user-id") Integer id) {
        return userService.banUser(id);
    }

    @DeleteMapping("/users/{user-id}")
    public void deleteUser(@PathVariable("user-id") Integer id) {
        userService.deleteUser(id);
    }


}
