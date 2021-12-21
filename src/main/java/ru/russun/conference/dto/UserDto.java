package ru.russun.conference.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.User;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String mail;
    private String role;
    private boolean isBanned;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .mail(user.getMail())
                .role(user.getRole().getRoleName())
                .isBanned(user.isBanned())
                .build();
    }
}
