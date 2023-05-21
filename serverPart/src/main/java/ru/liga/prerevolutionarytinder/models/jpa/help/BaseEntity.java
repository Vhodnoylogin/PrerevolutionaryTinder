package ru.liga.prerevolutionarytinder.models.jpa.help;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CREATE_DTTM")
    protected LocalDateTime createDateTime;

    @Column(name = "UPDATE_DTTM")
    protected LocalDateTime updateDateTime;

    @Column(name = "HASH_KEY")
    protected String hashKey;

    @PrePersist
    protected void prePersist() {
        createDateTime = LocalDateTime.now();
        updateDateTime = LocalDateTime.now();
        hashKey = generateHashKey();
    }

    @PreUpdate
    protected void preUpdate() {
        updateDateTime = LocalDateTime.now();
        hashKey = generateHashKey();
    }

    protected String generateHashKey() {
        return "42";
    }
}
