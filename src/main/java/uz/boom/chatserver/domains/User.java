package uz.boom.chatserver.domains;

import lombok.*;
import uz.boom.chatserver.domains.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 12:35 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable implements Comparable<User> {

    @Column(unique = true, nullable = false)
    private String username;

    @Builder
    public User(Long id, Timestamp createdAt, String username) {
        super(id, createdAt);
        this.username = username;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
