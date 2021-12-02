package ru.russun.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Room;

@Data
@Builder
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
