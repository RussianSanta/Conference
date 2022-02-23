package ru.russun.conference.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.russun.conference.entity.Room;

import java.util.List;

public interface RoomRepos extends CrudRepository<Room, String> {
    List<Room> findAll();
}
