package uz.boom.chatserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.boom.chatserver.domains.User;
import uz.boom.chatserver.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:07 PM 10/9/22 on Sunday in October
 */
public interface UserRepository extends BaseRepository, JpaRepository<User, Long> {
    @Query(value = " from User u where u.id in :listId")
    Optional<List<User>> findAllByIds(@Param(value = "listId") List<Long> listId);
}
