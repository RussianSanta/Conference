package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.UserDto;
import ru.russun.conference.entity.User;
import ru.russun.conference.repos.UserRepos;
import ru.russun.conference.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepos userRepos;

    @Override
    public UserDto getUser(Integer userId) {
        return UserDto.from(userRepos.findById(userId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .mail(userDto.getMail())
                .password(userDto.getPassword())
                .isBanned(false)
                .role(User.Role.USER)
                .build();
        userRepos.save(user);
        return UserDto.from(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepos.deleteById(userId);
    }

    @Override
    public UserDto banUser(Integer userId) {
        User userToBan = userRepos.findById(userId).orElseThrow(IllegalArgumentException::new);
        userToBan.setBanned(true);
        userRepos.save(userToBan);
        return UserDto.from(userToBan);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        User userToUpdate = userRepos.findById(userId).orElseThrow(IllegalArgumentException::new);
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setMail(user.getMail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setBanned(user.isBanned());
        userRepos.save(userToUpdate);
        return UserDto.from(userToUpdate);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepos.findAll().stream().map(UserDto::from).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getBannedUsers(boolean isBanned) {
        return userRepos.findAllUsersByIsBanned(isBanned).stream().map(UserDto::from).collect(Collectors.toList());
    }
}
