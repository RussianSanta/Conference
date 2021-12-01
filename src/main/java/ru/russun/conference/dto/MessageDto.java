package ru.russun.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Message;

import java.sql.Timestamp;

@Data
@Builder
public class MessageDto {
    private String text;
    private Timestamp date;
    private UserDto owner;
    private BranchDto branch;

    public static MessageDto from(Message message){
        return MessageDto.builder()
                .text(message.getText())
                .date(message.getDate())
                .owner(UserDto.from(message.getOwner()))
                .branch(BranchDto.from(message.getBranch()))
                .build();
    }
}
