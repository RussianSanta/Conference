package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.Member;
import ru.russun.conference.entity.Room;

import java.util.List;

public interface MemberRepos extends CrudRepository<Member, Integer> {
    List<Member> findAll();
    List<Member> findAllByRoom(Room room);
}

