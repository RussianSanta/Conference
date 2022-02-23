package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Room;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {
    private String id;
    private String code;

    public static RoomDto from(Room room){
        return RoomDto.builder()
                .id(room.getId())
                .code(room.getCode())
                .build();
    }
}
