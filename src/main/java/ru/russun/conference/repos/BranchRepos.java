package ru.russun.conference.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.russun.conference.entity.Branch;

import java.util.List;

public interface BranchRepos extends CrudRepository<Branch, Integer> {
    List<Branch> findAll();
    @Query("select b from Branch b where b.room.id = :roomId")
    List<Branch> findAllBranchesByRoomId(@Param("roomId") Integer roomId);
}
