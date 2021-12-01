package ru.russun.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Call;

import java.sql.Timestamp;

@Data
@Builder
public class CallDto {
    private String status;
    private Timestamp startDate;
    private Integer duration;
    private RoomDto room;

    public static CallDto from(Call call){
        return CallDto.builder()
                .status(call.getStatus())
                .startDate(call.getStartDate())
                .duration(call.getDuration())
                .room(RoomDto.from(call.getRoom()))
                .build();
    }
}
