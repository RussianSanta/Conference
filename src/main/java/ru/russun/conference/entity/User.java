package ru.russun.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public enum Role {
        ADMIN ("ADMIN"),
        USER ("USER");

        private String role;

        Role(String role){
            this.role = role;
        }

        public String getRoleName(){
            return role;
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "mail")
    private String mail;

    @Column(name = "isBanned")
    private boolean isBanned;

    @Column(name = "role")
    @Enumerated
    private Role role;
}
