package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.UserDto;
import ru.russun.conference.entity.Room;
import ru.russun.conference.entity.RoomUser;
import ru.russun.conference.entity.User;
import ru.russun.conference.repos.RoomRepos;
import ru.russun.conference.repos.RoomUserRepos;
import ru.russun.conference.repos.UserRepos;
import ru.russun.conference.service.RoomService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepos roomRepos;
    @Autowired
    UserRepos userRepos;
    @Autowired
    RoomUserRepos roomUserRepos;

    @Override
    public RoomDto getRoom(Integer roomId) {
        return RoomDto.from(roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public RoomDto addRoom(RoomDto roomDto) {
        User owner = userRepos.findById(roomDto.getOwner().getId()).orElseThrow(IllegalArgumentException::new);
        Room room = Room.builder()
                .owner(owner)
                .name(roomDto.getName())
                .build();
        roomRepos.save(room);
        RoomUser roomUser = new RoomUser(room, owner);
        roomUserRepos.save(roomUser);
        return RoomDto.from(room);
    }

    @Override
    public void deleteRoom(Integer roomID) {
        roomRepos.deleteById(roomID);
    }

    @Override
    public RoomDto updateRoom(RoomDto room, Integer roomId) {
        Room roomForUpdate = roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new);
        User owner = userRepos.findById(room.getOwner().getId()).orElseThrow(IllegalArgumentException::new);
        roomForUpdate.setName(room.getName());
        roomForUpdate.setOwner(owner);
        roomUserRepos.save(new RoomUser(roomForUpdate,owner));
        roomRepos.save(roomForUpdate);
        return RoomDto.from(roomForUpdate);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepos.findAll().stream().map(RoomDto::from).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getOwnedRoom(Integer userId) {
        return roomRepos.findRoomsByOwner(userId).stream().map(RoomDto::from).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> addUserToRoom(Integer userId, Integer roomId) {
        User user = userRepos.findById(userId).orElseThrow(IllegalArgumentException::new);
        Room room = roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new);
        RoomUser roomUser = new RoomUser(room, user);
        roomUserRepos.save(roomUser);
        return roomUserRepos.findAllByRoomId(roomId).stream().map(RoomUser::getUser).map(UserDto::from).collect(Collectors.toList());
    }
}
