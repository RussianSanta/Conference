package ru.russun.conference.service;

import ru.russun.conference.dto.MessageDto;

import java.util.List;

public interface MessageService {
    MessageDto getMessage(Integer messageId);

    MessageDto addMessage(MessageDto message);

    void deleteMessage(Integer messageId);

    MessageDto updateMessage(MessageDto message, Integer messageID);

    List<MessageDto> getAllMessages();

    List<MessageDto> getAllMessagesByBranch(Integer branchId);

    List<MessageDto> getAllMessagesByRoom(Integer roomId);
}
