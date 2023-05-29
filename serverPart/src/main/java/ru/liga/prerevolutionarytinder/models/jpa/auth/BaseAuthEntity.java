package ru.liga.prerevolutionarytinder.models.jpa.auth;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class BaseAuthEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "global_id", referencedColumnName = "global_id")
    private GlobalUUIDEntity globalUUIDEntity;
}
