package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.Branch;

import java.util.List;

public interface BranchRepos extends CrudRepository<Branch, Integer> {
    List<Branch> findAll();
}
