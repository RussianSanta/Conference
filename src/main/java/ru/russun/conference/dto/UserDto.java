package ru.russun.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.russun.conference.entity.User;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String mail;
    private String role;

    public static UserDto from(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .mail(user.getMail())
                .role(user.getRole().getRoleName())
                .build();
    }
}
