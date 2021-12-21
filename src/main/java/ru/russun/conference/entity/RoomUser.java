package ru.russun.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RoomUser.RoomUserPk.class)
public class RoomUser {
    @Embeddable
    public static class RoomUserPk implements Serializable {
        protected Integer room;
        protected Integer user;

        public RoomUserPk() {
        }

        public RoomUserPk(Room call, User user) {
            this.room = call.getId();
            this.user = user.getId();
        }
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id_fk")
    private Room room;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id_fk")
    private User user;
}
