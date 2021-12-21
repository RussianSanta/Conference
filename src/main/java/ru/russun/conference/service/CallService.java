package ru.russun.conference.service;

import ru.russun.conference.dto.CallDto;

import java.util.List;

public interface CallService {
    CallDto getCall(Integer callId);

    CallDto addCall(CallDto call);

    void deleteCall(Integer callId);

    CallDto updateCall(CallDto call, Integer callId);

    List<CallDto> getAllCalls();

    List<CallDto> getAllCallsByRoom(Integer roomId);
}
