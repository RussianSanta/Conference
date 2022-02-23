package ru.russun.conference.service;

import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.MemberDto;

import java.util.List;

public interface RoomService {
    RoomDto getRoom(String roomId);

    RoomDto addRoom(RoomDto room);

    void deleteRoom(String roomID);

    List<RoomDto> getAllRooms();

    void addUserToRoom(MemberDto member);

    List<MemberDto> getMembers(RoomDto room);

    void checkMembers(RoomDto room);
}
