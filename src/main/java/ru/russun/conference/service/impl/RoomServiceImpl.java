package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.MemberDto;
import ru.russun.conference.entity.Member;
import ru.russun.conference.entity.Room;
import ru.russun.conference.repos.RoomRepos;
import ru.russun.conference.repos.MemberRepos;
import ru.russun.conference.service.RoomService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepos roomRepos;
    @Autowired
    MemberRepos memberRepos;

    @Override
    public RoomDto getRoom(String roomId) {
        return RoomDto.from(roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public RoomDto addRoom(RoomDto roomDto) {
        Room room = Room.builder()
                .id(roomDto.getId())
                .code(roomDto.getCode())
                .build();
        roomRepos.save(room);
        return RoomDto.from(room);
    }

    @Override
    public void deleteRoom(String roomID) {
        roomRepos.deleteById(roomID);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepos.findAll().stream().map(RoomDto::from).collect(Collectors.toList());
    }

    @Override
    public void addUserToRoom(MemberDto memberDto) {
        Room roomFromDto = roomRepos.findById(memberDto.getRoomId()).orElseThrow(IllegalArgumentException::new);
        Member member = Member.builder()
                .room(roomFromDto)
                .name(memberDto.getName())
                .build();
    }

    @Override
    public List<MemberDto> getMembers(RoomDto roomDto) {
        Room roomFromDto = roomRepos.findById(roomDto.getId()).orElseThrow(IllegalArgumentException::new);
        return memberRepos.findAllByRoom(roomFromDto).stream().map(MemberDto::from).collect(Collectors.toList());
    }

    @Override
    public void checkMembers(RoomDto roomDto) {
        if (getMembers(roomDto) != null) {
            int count = getMembers(roomDto).size();
            if (count == 0) {
                deleteRoom(roomDto.getId());
            }
        }
    }
}
