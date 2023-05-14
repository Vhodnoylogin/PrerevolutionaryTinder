package ru.liga.prerevolutionarytinder.models.jpa.auth;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "global_uuid_table")
@Data
public class GlobalUUIDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "global_id")
    private Long globalId;

    @Column(name = "uuid", unique = true)
    private String uuid;

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }
}
