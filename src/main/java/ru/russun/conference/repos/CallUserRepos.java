package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.CallUser;

public interface CallUserRepos extends CrudRepository<CallUser,CallUser.CallUserPk> {
}
