package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.CallDto;
import ru.russun.conference.entity.Call;
import ru.russun.conference.repos.CallRepos;
import ru.russun.conference.repos.RoomRepos;
import ru.russun.conference.service.CallService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CallServiceImpl implements CallService {
    @Autowired
    CallRepos callRepos;
    @Autowired
    RoomRepos roomRepos;

    @Override
    public CallDto getCall(Integer callId) {
        return CallDto.from(callRepos.findById(callId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public CallDto addCall(CallDto callDto) {
        Call call = Call.builder()
                .status(callDto.getStatus())
                .duration(callDto.getDuration())
                .room(roomRepos.findById(callDto.getRoom().getId()).orElseThrow(IllegalArgumentException::new))
                .startDate(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        callRepos.save(call);
        return CallDto.from(call);
    }

    @Override
    public void deleteCall(Integer callId) {
        callRepos.deleteById(callId);
    }

    @Override
    public CallDto updateCall(CallDto call, Integer callId) {
        Call callToUpdate = callRepos.findById(callId).orElseThrow(IllegalArgumentException::new);
        callToUpdate.setDuration(call.getDuration());
        callToUpdate.setStatus(call.getStatus());
        callRepos.save(callToUpdate);
        return CallDto.from(callToUpdate);
    }

    @Override
    public List<CallDto> getAllCalls() {
        return callRepos.findAll().stream().map(CallDto::from).collect(Collectors.toList());
    }

    @Override
    public List<CallDto> getAllCallsByRoom(Integer roomId) {
        return callRepos.findAllByRoom(roomId).stream().map(CallDto::from).collect(Collectors.toList());
    }
}
