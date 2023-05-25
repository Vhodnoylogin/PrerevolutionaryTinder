package ru.liga.prerevolutionarytinder.models.jpa.auth.web;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.auth.BaseAuthEntity;

//@Entity
@Table(name = "web_auth")
//@Table(name = "telegram_auth", schema = "my_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class WebAuthEntity extends BaseAuthEntity {
    @Column(name = "user_name", nullable = false, unique = true)
    private String user_name;
}
