package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Message;

import java.sql.Timestamp;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
    private Integer id;
    private String text;
    private Timestamp date;
    private UserDto owner;
    private BranchDto branch;

    public static MessageDto from(Message message){
        return MessageDto.builder()
                .id(message.getId())
                .text(message.getText())
                .date(message.getDate())
                .owner(UserDto.from(message.getOwner()))
                .branch(BranchDto.from(message.getBranch()))
                .build();
    }
}
