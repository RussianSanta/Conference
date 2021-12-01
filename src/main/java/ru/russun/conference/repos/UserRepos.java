package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepos extends CrudRepository<User, Integer> {
    Optional<User> findUserByBannedIsFalseAndId(Integer userId);

    List<User> findAll();
}
