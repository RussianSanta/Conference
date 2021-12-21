package ru.russun.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "call_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CallUser.CallUserPk.class)
public class CallUser {
    @Embeddable
    public static class CallUserPk implements Serializable {
        protected Integer call;
        protected Integer user;

        public CallUserPk() {
        }

        public CallUserPk(Call call, User user) {
            this.call = call.getId();
            this.user = user.getId();
        }
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "call_id_fk")
    private Call call;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id_fk")
    protected User user;
}
