package ru.liga.prerevolutionarytinder.models.jpa.auth;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AnyAuthEntity extends BaseEntity {
    @Id
    @OneToOne
    @JoinColumn(name = "global_id")
    private GlobalUUIDEntity globalUUIDEntity;
}
