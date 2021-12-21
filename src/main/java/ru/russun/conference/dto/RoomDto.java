package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Room;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {
    private Integer id;
    private String name;
    private UserDto owner;

    public static RoomDto from(Room room){
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .owner(UserDto.from(room.getOwner()))
                .build();
    }
}
