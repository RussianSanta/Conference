package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.entity.Room;
import ru.russun.conference.repos.RoomRepos;
import ru.russun.conference.repos.UserRepos;
import ru.russun.conference.service.RoomService;

import javax.persistence.Access;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepos roomRepos;
    @Autowired
    UserRepos userRepos;

    @Override
    public RoomDto getRoom(Integer roomId) {
        return RoomDto.from(roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public RoomDto addRoom(RoomDto roomDto) {
        Room room = Room.builder()
                .owner(userRepos.findById(roomDto.getOwner().getId()).orElseThrow(IllegalArgumentException::new))
                .name(roomDto.getName())
                .build();
        roomRepos.save(room);
        return RoomDto.from(room);
    }

    @Override
    public void deleteRoom(Integer roomID) {
        roomRepos.deleteById(roomID);
    }

    @Override
    public RoomDto updateRoom(RoomDto room, Integer roomId) {
        Room roomForUpdate = roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new);
        roomForUpdate.setName(room.getName());
        roomRepos.save(roomForUpdate);
        return RoomDto.from(roomForUpdate);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepos.findAll().stream().map(RoomDto::from).collect(Collectors.toList());
    }
}
