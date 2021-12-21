package ru.russun.conference.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.MessageDto;
import ru.russun.conference.entity.Message;
import ru.russun.conference.repos.BranchRepos;
import ru.russun.conference.repos.MessageRepos;
import ru.russun.conference.repos.UserRepos;
import ru.russun.conference.service.MessageService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepos messageRepos;
    @Autowired
    BranchRepos branchRepos;
    @Autowired
    UserRepos userRepos;

    @Override
    public MessageDto getMessage(Integer messageId) {
        return MessageDto.from(messageRepos.findById(messageId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public MessageDto addMessage(MessageDto messageDto) {
        Message message = Message.builder()
                .branch(branchRepos.findById(messageDto.getBranch().getId()).orElseThrow(IllegalArgumentException::new))
                .date(Timestamp.valueOf(LocalDateTime.now()))
                .owner(userRepos.findById(messageDto.getOwner().getId()).orElseThrow(IllegalArgumentException::new))
                .text(messageDto.getText())
                .build();
        messageRepos.save(message);
        return MessageDto.from(message);
    }

    @Override
    public void deleteMessage(Integer messageId) {
        messageRepos.deleteById(messageId);
    }

    @Override
    public MessageDto updateMessage(MessageDto message, Integer messageID) {
        Message messageToUpdate = messageRepos.findById(messageID).orElseThrow(IllegalArgumentException::new);
        messageToUpdate.setText(message.getText());
        messageRepos.save(messageToUpdate);
        return MessageDto.from(messageToUpdate);
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return messageRepos.findAll().stream().map(MessageDto::from).collect(Collectors.toList());
    }

    @Override
    public List<MessageDto> getAllMessagesByBranch(Integer branchId) {
        return messageRepos.findAllByBranch(branchId).stream().map(MessageDto::from).collect(Collectors.toList());
    }

    @Override
    public List<MessageDto> getAllMessagesByRoom(Integer roomId) {
        return messageRepos.findAllByRoom(roomId).stream().map(MessageDto::from).collect(Collectors.toList());
    }
}
