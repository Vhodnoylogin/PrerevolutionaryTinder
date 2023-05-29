package ru.liga.prerevolutionarytinder.repository.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;

@Profile("disabled")
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
