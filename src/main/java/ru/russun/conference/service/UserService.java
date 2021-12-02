package ru.russun.conference.service;

import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUser(Integer userId);

    UserDto addUser(UserDto user);

    void deleteUser(Integer userId);

    UserDto banUser(Integer userId);

    UserDto updateUser(UserDto user, Integer userId);

    List<UserDto> getAllUsers();

    List<UserDto> getBannedUsers(boolean isBanned);

}
