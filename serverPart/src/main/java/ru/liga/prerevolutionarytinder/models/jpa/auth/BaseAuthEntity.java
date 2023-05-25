package ru.liga.prerevolutionarytinder.models.jpa.auth;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class BaseAuthEntity {

}
