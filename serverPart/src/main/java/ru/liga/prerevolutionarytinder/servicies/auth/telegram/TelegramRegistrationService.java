package ru.liga.prerevolutionarytinder.servicies.auth.telegram;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.telegram.TelegramAuthEntity;
import ru.liga.prerevolutionarytinder.persistence.auth.telegram.TelegramAuthMapper;
import ru.liga.prerevolutionarytinder.repository.auth.telegram.TelegramRegistrationRepository;

@Service
public class TelegramRegistrationService {
    private final TelegramRegistrationRepository registrationRepository;
    private final TelegramAuthMapper telegramAuthMapper;

    @Autowired
    public TelegramRegistrationService(TelegramRegistrationRepository registrationRepository, TelegramAuthMapper telegramAuthMapper) {
        this.registrationRepository = registrationRepository;
        this.telegramAuthMapper = telegramAuthMapper;
    }

    public TelegramAuthEntity create(TelegramRegistrationInfo registrationInfo) {
        var telegramAuthEntity = telegramAuthMapper.mapToEntity(registrationInfo);
        return registrationRepository.save(telegramAuthEntity);
//        return telegramAuthEntity;
    }
}
