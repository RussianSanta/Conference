package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.*;
import ru.russun.conference.service.MessageService;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public List<MessageDto> getAllMessages(@RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<MessageDto> messages = messageService.getAllMessages();
        if (!expand) {
            for (MessageDto message : messages) {
                message.setBranch(BranchDto.builder().id(message.getBranch().getId()).build());
                message.setOwner(UserDto.builder().id(message.getOwner().getId()).build());
            }
        }
        return messages;
    }

    @GetMapping("/messages/{message-id}")
    public MessageDto getMessage(@PathVariable("message-id") Integer id,
                                 @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        MessageDto message = messageService.getMessage(id);
        if (!expand) {
            message.setBranch(BranchDto.builder().id(message.getBranch().getId()).build());
            message.setOwner(UserDto.builder().id(message.getOwner().getId()).build());
        }
        return message;
    }

    @GetMapping("/branches/{branch-id}/messages")
    public List<MessageDto> getMessagesInBranch(@PathVariable("branch-id") Integer id,
                                                @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<MessageDto> messages = messageService.getAllMessagesByBranch(id);
        if (!expand) {
            for (MessageDto message : messages) {
                message.setBranch(BranchDto.builder().id(message.getBranch().getId()).build());
                message.setOwner(UserDto.builder().id(message.getOwner().getId()).build());
            }
        }
        return messages;
    }

    @GetMapping("/rooms/{room-id}/messages")
    public List<MessageDto> getMessagesInRoom(@PathVariable("room-id") Integer id,
                                              @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<MessageDto> messages = messageService.getAllMessagesByRoom(id);
        if (!expand) {
            for (MessageDto message : messages) {
                message.setBranch(BranchDto.builder().id(message.getBranch().getId()).build());
                message.setOwner(UserDto.builder().id(message.getOwner().getId()).build());
            }
        }
        return messages;
    }

    @PostMapping("/messages/new")
    public MessageDto createNewMessage(@RequestBody MessageDto messageDto,
                                       @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        MessageDto message = messageService.addMessage(messageDto);
        if (!expand) {
            message.setBranch(BranchDto.builder().id(message.getBranch().getId()).build());
            message.setOwner(UserDto.builder().id(message.getOwner().getId()).build());
        }
        return message;
    }

    @PutMapping("/messages/{message-id}")
    public MessageDto updateMessageData(@RequestBody MessageDto messageDto, @PathVariable("message-id") Integer id,
                                        @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        MessageDto message = messageService.updateMessage(messageDto, id);
        if (!expand) {
            message.setBranch(BranchDto.builder().id(message.getBranch().getId()).build());
            message.setOwner(UserDto.builder().id(message.getOwner().getId()).build());
        }
        return message;
    }

    @DeleteMapping("/messages/{message-id}")
    public void deleteMessage(@PathVariable("message-id") Integer id) {
        messageService.deleteMessage(id);
    }

}
