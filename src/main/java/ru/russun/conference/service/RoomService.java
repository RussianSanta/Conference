package ru.russun.conference.service;

import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.UserDto;
import ru.russun.conference.entity.RoomUser;

import java.util.List;

public interface RoomService {
    RoomDto getRoom(Integer roomId);

    RoomDto addRoom(RoomDto room);

    void deleteRoom(Integer roomID);

    RoomDto updateRoom(RoomDto room, Integer roomId);

    List<RoomDto> getAllRooms();

    List<RoomDto> getOwnedRoom(Integer userId);

    List<UserDto> addUserToRoom(Integer userId, Integer roomId);
}
