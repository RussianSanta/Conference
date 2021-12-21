package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.BranchDto;
import ru.russun.conference.dto.CallDto;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.service.CallService;

import java.util.List;

@RestController
public class CallController {
    @Autowired
    CallService callService;

    @GetMapping("/calls")
    public List<CallDto> getAllCalls(@RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<CallDto> calls = callService.getAllCalls();
        if (!expand) {
            for (CallDto call : calls) {
                call.setRoom(RoomDto.builder().id(call.getRoom().getId()).build());
            }
        }
        return calls;
    }

    @GetMapping("/calls/{call-id}")
    public CallDto getCall(@PathVariable("call-id") Integer id,
                           @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        CallDto call = callService.getCall(id);
        if (!expand) call.setRoom(RoomDto.builder().id(call.getRoom().getId()).build());
        return call;
    }

    @GetMapping("/rooms/{room-id}/calls")
    public List<CallDto> getCallsInRoom(@PathVariable("room-id") Integer id,
                                        @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<CallDto> calls = callService.getAllCallsByRoom(id);
        if (!expand) {
            for (CallDto call : calls) {
                call.setRoom(RoomDto.builder().id(call.getRoom().getId()).build());
            }
        }
        return calls;
    }

    @PostMapping("/calls/new")
    public CallDto createNewCall(@RequestBody CallDto callDto,
                                 @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        CallDto call = callService.addCall(callDto);
        if (!expand) call.setRoom(RoomDto.builder().id(call.getRoom().getId()).build());
        return  call;
    }

    @PutMapping("/calls/{call-id}")
    public CallDto updateCallData(@RequestBody CallDto callDto, @PathVariable("call-id") Integer id,
                                  @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        CallDto call = callService.updateCall(callDto, id);
        if (!expand) call.setRoom(RoomDto.builder().id(call.getRoom().getId()).build());
        return call;
    }

    @DeleteMapping("/calls/{call-id}")
    public void deleteCall(@PathVariable("call-id") Integer id) {
        callService.deleteCall(id);
    }

}
