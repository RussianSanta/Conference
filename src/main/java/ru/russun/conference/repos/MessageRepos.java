package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.Message;

import java.util.List;

public interface MessageRepos extends CrudRepository<Message, Integer> {
    List<Message> findAll();
}
