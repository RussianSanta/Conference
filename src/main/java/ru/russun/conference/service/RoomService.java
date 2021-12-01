package ru.russun.conference.service;

import ru.russun.conference.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto getRoom(Integer roomId);

    RoomDto addRoom(RoomDto room);

    void deleteRoom(Integer roomID);

    RoomDto updateRoom(RoomDto room, Integer roomId);

    List<RoomDto> getAllRooms();
}
