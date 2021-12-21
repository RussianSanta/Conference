package ru.russun.conference.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.russun.conference.entity.Message;

import java.util.List;

public interface MessageRepos extends CrudRepository<Message, Integer> {
    List<Message> findAll();

    @Query("select m from Message m where m.branch.id = :branchId")
    List<Message> findAllByBranch(@Param("branchId") Integer branchId);

    @Query("select m from Message m where m.branch.room.id = :roomId")
    List<Message> findAllByRoom(@Param("roomId") Integer roomId);
}
