package uz.boom.chatserver.domains;

import lombok.*;
import uz.boom.chatserver.domains.base.Auditable;
import uz.boom.chatserver.enums.MessageType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:00 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message extends Auditable implements Comparable<Message>{


    @OneToOne(fetch = FetchType.LAZY)
    private Chat chat;

    @ManyToOne
    private User author;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MessageType messageType;

    @Column(nullable = false)
    private String content;

    @Builder
    public Message(Long id, Timestamp createdAt, Chat chat, User author, MessageType messageType, String content) {
        super(id, createdAt);
        this.chat = chat;
        this.author = author;
        this.messageType = messageType;
        this.content = content;
    }

    @Override
    public int compareTo(Message o) {
        return 0;
    }
}
