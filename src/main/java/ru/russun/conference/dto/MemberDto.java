package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.Member;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDto {
    private Integer id;
    private String name;
    private String roomId;

    public static MemberDto from(Member member){
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .roomId(member.getRoom().getId())
                .build();
    }
}
