package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Call;

import java.sql.Timestamp;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallDto {
    private Integer id;
    private String status;
    private Timestamp startDate;
    private Integer duration;
    private RoomDto room;

    public static CallDto from(Call call) {
        return CallDto.builder()
                .id(call.getId())
                .status(call.getStatus())
                .startDate(call.getStartDate())
                .duration(call.getDuration())
                .room(RoomDto.from(call.getRoom()))
                .build();
    }
}
