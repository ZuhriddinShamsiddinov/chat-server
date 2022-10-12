package uz.boom.chatserver.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import uz.boom.chatserver.domains.base.Auditable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:00 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"users"})
public class Chat extends Auditable implements Comparable<Chat>{

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "chat_users",
            joinColumns = {@JoinColumn(name = "chat_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")})
    private List<User> users;


    @Builder
    public Chat(Long id, Timestamp createdAt, String name, List<User> users) {
        super(id, createdAt);
        this.name = name;
        this.users = users;
    }

    @Override
    public int compareTo(Chat o) {
        return 0;
    }
}