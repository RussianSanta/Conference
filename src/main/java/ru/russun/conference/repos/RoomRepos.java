package ru.russun.conference.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.russun.conference.entity.Room;

import java.util.List;

public interface RoomRepos extends CrudRepository<Room, Integer> {
    List<Room> findAll();
    @Query("select r from Room r where r.owner.id = :userId")
    List<Room> findRoomsByOwner(@Param("userId") Integer userId);
}
