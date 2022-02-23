package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.MemberDto;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.service.MemberService;
import ru.russun.conference.service.RoomService;

import java.util.List;

@RestController()
@CrossOrigin
public class MainController {
    @Autowired
    RoomService roomService;
    @Autowired
    MemberService memberService;

    @GetMapping("/home/all")
    public List<RoomDto> getRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping("/home/new")
    public RoomDto createRoom(@RequestBody RoomDto roomDto) {
        return roomService.addRoom(roomDto);
    }

    @PostMapping("/home/connect")
    public boolean connectToRoom(@RequestBody RoomDto roomDto) {
        return roomService.getRoom(roomDto.getId()).getCode().equals(roomDto.getCode());
    }
}
