package ru.russun.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Branch;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Data
@Builder
public class BranchDto {
    private String name;
    private RoomDto room;

    public static BranchDto from(Branch branch) {
        return BranchDto.builder()
                .name(branch.getName())
                .room(RoomDto.from(branch.getRoom()))
                .build();
    }
}
