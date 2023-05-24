package ru.liga.prerevolutionarytinder.repository.auth.telegram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.prerevolutionarytinder.models.jpa.auth.telegram.TelegramAuthEntity;

@Repository
public interface TelegramRegistrationRepository extends JpaRepository<TelegramAuthEntity, Long> {
}
