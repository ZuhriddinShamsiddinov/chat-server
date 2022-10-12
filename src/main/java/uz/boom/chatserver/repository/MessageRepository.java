package uz.boom.chatserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.chatserver.domains.Chat;
import uz.boom.chatserver.domains.Message;
import uz.boom.chatserver.repository.base.BaseRepository;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:07 PM 10/9/22 on Sunday in October
 */
public interface MessageRepository extends BaseRepository, JpaRepository<Message, Long> {
    List<Message> findAllByChat(Chat chat);
}
