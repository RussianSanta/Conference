package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.dto.UserDto;
import ru.russun.conference.service.RoomService;

import java.util.List;

@RestController
@CrossOrigin
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomDto> getAllRooms(@RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<RoomDto> rooms = roomService.getAllRooms();
        if (!expand) {
            for (RoomDto room : rooms) {
                room.setOwner(UserDto.builder().id(room.getOwner().getId()).build());
            }
        }
        return rooms;
    }

    @GetMapping("/rooms/{room-id}")
    public RoomDto getRoom(@PathVariable("room-id") Integer id,
                           @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        RoomDto room = roomService.getRoom(id);
        if (!expand) room.setOwner(UserDto.builder().id(room.getOwner().getId()).build());
        return room;
    }

    @GetMapping("/rooms/owner={user-id}")
    public List<RoomDto> getRoomsByOwner(@PathVariable("user-id") Integer id,
                                         @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<RoomDto> rooms = roomService.getOwnedRoom(id);
        if (!expand) {
            for (RoomDto room : rooms) {
                room.setOwner(UserDto.builder().id(room.getOwner().getId()).build());
            }
        }
        return rooms;
    }

    @PostMapping("/rooms")
    public RoomDto createNewRoom(@RequestBody RoomDto roomDto,
                                 @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        RoomDto room = roomService.addRoom(roomDto);
        if (!expand) room.setOwner(UserDto.builder().id(room.getOwner().getId()).build());
        return room;
    }

    @PostMapping("/rooms/{room-id}/{user-id}")
    public List<UserDto> addNewUser(@PathVariable("user-id") Integer userId, @PathVariable("room-id") Integer roomId,
                                    @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        return roomService.addUserToRoom(userId, roomId);
    }

    @PutMapping("/rooms/{room-id}")
    public RoomDto updateRoomData(@RequestBody RoomDto roomDto, @PathVariable("room-id") Integer id,
                                  @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        RoomDto room = roomService.updateRoom(roomDto, id);
        if (!expand) room.setOwner(UserDto.builder().id(room.getOwner().getId()).build());
        return room;
    }

    @DeleteMapping("/rooms/{room-id}")
    public void deleteRoom(@PathVariable("room-id") Integer id) {
        roomService.deleteRoom(id);
    }
}
