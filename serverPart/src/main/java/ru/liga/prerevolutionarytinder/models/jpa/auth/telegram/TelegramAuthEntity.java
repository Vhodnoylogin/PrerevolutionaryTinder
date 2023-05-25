package ru.liga.prerevolutionarytinder.models.jpa.auth.telegram;

import jakarta.persistence.*;
import lombok.Data;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;

@Entity
@Table(name = "telegram_auth")
//@Table(name = "telegram_auth", schema = "my_schema")
@Data
//@EqualsAndHashCode(callSuper = true)
//@IdClass(GlobalUserId.class)
public class TelegramAuthEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

//    @Column(name = "user_name", nullable = false, unique = true)
//    private String userName;

    @OneToOne
    @JoinColumn(name = "global_id")
    private GlobalUUIDEntity globalUUIDEntity;
}
