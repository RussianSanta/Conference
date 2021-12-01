package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.Room;

import java.util.List;

public interface RoomRepos extends CrudRepository<Room, Integer> {
    List<Room> findAll();
}
