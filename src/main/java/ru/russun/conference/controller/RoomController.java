package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.service.RoomService;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{room-id}")
    public RoomDto getRoom(@PathVariable("room-id") Integer id) {
        return roomService.getRoom(id);
    }

    @GetMapping("/rooms/owner={user-id}")
    public List<RoomDto> getRoomsByOwner(@PathVariable("user-id") Integer id) {
        return roomService.getOwnedRoom(id);
    }

    @PostMapping("/rooms/new")
    public RoomDto createNewRoom(@RequestBody RoomDto roomDto) {
        return  roomService.addRoom(roomDto);
    }

    @PutMapping("/rooms/{room-id}")
    public RoomDto updateRoomData(@RequestBody RoomDto roomDto, @PathVariable("room-id") Integer id) {
        return roomService.updateRoom(roomDto, id);
    }

    @DeleteMapping("/rooms/{room-id}")
    public void deleteRoom(@PathVariable("room-id") Integer id) {
        roomService.deleteRoom(id);
    }
}
