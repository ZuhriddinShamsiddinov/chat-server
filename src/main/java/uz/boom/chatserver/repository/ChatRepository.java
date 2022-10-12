package uz.boom.chatserver.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.boom.chatserver.domains.Chat;
import uz.boom.chatserver.repository.base.BaseRepository;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:07 PM 10/9/22 on Sunday in October
 */
public interface ChatRepository extends BaseRepository, JpaRepository<Chat, Long> {

    @Query(nativeQuery = true, value = "select * from chat join chat_users cu on chat.id = cu.chat_id where cu.users_id=:userId")
    List<Chat> findAllByUserId(@Param("userId") Long userId);
}
