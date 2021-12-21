package ru.russun.conference.repos;

import org.springframework.data.repository.CrudRepository;
import ru.russun.conference.entity.RoomUser;

import java.util.List;

public interface RoomUserRepos extends CrudRepository<RoomUser, RoomUser.RoomUserPk> {
    List<RoomUser> findAllByRoomId(Integer roomId);
}
