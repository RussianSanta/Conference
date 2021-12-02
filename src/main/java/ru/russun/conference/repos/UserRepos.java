package ru.russun.conference.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.russun.conference.entity.Room;
import ru.russun.conference.entity.User;

import java.util.List;

public interface UserRepos extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findByUsername(String username);
    List<User> findAllUsersByIsBanned(boolean banned);
}
