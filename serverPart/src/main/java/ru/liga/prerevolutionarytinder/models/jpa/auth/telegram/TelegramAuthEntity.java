package ru.liga.prerevolutionarytinder.models.jpa.auth.telegram;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;

@Entity
@Table(name = "telegram_auth")
@Data
@EqualsAndHashCode(callSuper = true)
public class TelegramAuthEntity extends BaseEntity {
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
