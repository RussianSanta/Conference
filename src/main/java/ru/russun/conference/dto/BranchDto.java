package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Branch;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchDto {
    private Integer id;
    private String name;
    private RoomDto room;

    public static BranchDto from(Branch branch) {
        return BranchDto.builder()
                .id(branch.getId())
                .name(branch.getName())
                .room(RoomDto.from(branch.getRoom()))
                .build();
    }
}
