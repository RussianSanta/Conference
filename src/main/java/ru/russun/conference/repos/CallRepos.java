package ru.russun.conference.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.russun.conference.entity.Call;

import java.util.List;

public interface CallRepos extends CrudRepository<Call, Integer> {
    List<Call> findAll();
    @Query("select c from Call c where c.room.id = :roomId")
    List<Call> findAllByRoom(@Param("roomId") Integer roomId);
}
