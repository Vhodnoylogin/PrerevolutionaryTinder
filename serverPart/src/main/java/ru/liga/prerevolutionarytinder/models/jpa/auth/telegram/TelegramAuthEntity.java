package ru.liga.prerevolutionarytinder.models.jpa.auth.telegram;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.auth.BaseAuthEntity;

@Entity
@Table(name = "TELEGRAM_AUTH")
//@Table(name = "TELEGRAM_AUTH", schema = "MY_SCHEMA")
@Data
@EqualsAndHashCode(callSuper = true)
public class TelegramAuthEntity extends BaseAuthEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
}
