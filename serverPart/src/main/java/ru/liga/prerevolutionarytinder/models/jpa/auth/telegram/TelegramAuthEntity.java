package ru.liga.prerevolutionarytinder.models.jpa.auth.telegram;

import jakarta.persistence.*;
import lombok.Data;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;

@Entity
@Table(name = "telegram_auth")
@Data
public class TelegramAuthEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "global_id")
//    private Long globalId;

    @Id
    @OneToOne
    @JoinColumn(name = "global_id")
    private GlobalUUIDEntity globalUUIDEntity;

    @Column(name = "user_id", nullable = false, unique = true)
    private Integer userId;
}
