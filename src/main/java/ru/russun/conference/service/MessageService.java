package ru.russun.conference.service;

import ru.russun.conference.dto.MessageDto;

import java.util.List;

public interface MessageService {
    MessageDto getMessage(Integer messageId);

    MessageDto addMessage(MessageDto message, Integer branchId);

    void deleteMessage(Integer messageId);

    MessageDto updateMessage(MessageDto message, Integer messageID);

    List<MessageDto> getAllMessages();
}
