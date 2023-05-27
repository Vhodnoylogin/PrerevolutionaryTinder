package ru.liga.prerevolutionarytinder.repository.auth.globalUUID;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;

public interface GlobalUUIDRepository extends JpaRepository<GlobalUUIDEntity, Long>, GlobalUUIDCustomRepository {
}
