package ru.russun.conference.controller;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.MemberDto;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.service.MemberService;
import ru.russun.conference.service.RoomService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController()
@CrossOrigin
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    MemberService memberService;

    @GetMapping("/room/{roomId}/members")
    public List<MemberDto> getMembers(@PathVariable("roomId") String roomId) {
        System.out.println(roomId);
        RoomDto roomDto = roomService.getRoom(roomId);
        return roomService.getMembers(roomDto);
    }

    @PostMapping("/room/{roomId}/connect")
    public MemberDto connectToRoom(@PathVariable("roomId") String roomId, @RequestBody MemberDto memberDto) {
        return memberService.addMember(memberDto);
    }

    @DeleteMapping("/room/{roomId}/leave")
    public void leave(@PathVariable("roomId") String roomId, @RequestBody MemberDto memberDto) {
        RoomDto roomDto = roomService.getRoom(roomId);
        memberService.deleteMember(memberDto);
        roomService.checkMembers(roomDto);
    }
}
