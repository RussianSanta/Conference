package ru.russun.conference.service;

import ru.russun.conference.dto.CallDto;

import java.util.List;

public interface CallService {
    CallDto getCall(Integer callId);

    CallDto addCall(CallDto call, Integer roomId);

    void deleteCall(Integer callId);

    CallDto updateCall(CallDto call, Integer callId);

    List<CallDto> getAllCalls();
}
