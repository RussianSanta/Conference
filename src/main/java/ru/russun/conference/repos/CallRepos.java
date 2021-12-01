package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.Call;

import java.util.List;

public interface CallRepos extends CrudRepository<Call, Integer> {
    List<Call> findAll();
}
