package uz.boom.chatserver.domains.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 5:21 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Auditable implements BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "timestamp with time zone default current_timestamp")
    private Timestamp createdAt;

    public Auditable(Long id, Timestamp createdAt) {
        this.id = id;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
