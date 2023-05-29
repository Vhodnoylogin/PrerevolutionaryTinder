package ru.liga.prerevolutionarytinder.repository.auth.globalUUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;

@Repository
public interface GlobalUUIDRepository extends JpaRepository<GlobalUUIDEntity, Long> {
}
