package ru.russun.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private String id;

    private String code;
}
