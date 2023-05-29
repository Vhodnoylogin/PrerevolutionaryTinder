package ru.liga.prerevolutionarytinder.models.jpa.auth.web;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.auth.BaseAuthEntity;

@Entity
@Table(name = "WEB_AUTH")
//@Table(name = "WEB_AUTH", schema = "my_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class WebAuthEntity extends BaseAuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String user_name;
}
