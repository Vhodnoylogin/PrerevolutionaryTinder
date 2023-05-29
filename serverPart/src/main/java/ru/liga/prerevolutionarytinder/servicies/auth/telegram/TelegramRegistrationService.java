package ru.liga.prerevolutionarytinder.servicies.auth.telegram;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.models.auth.SourceType;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;
import ru.liga.prerevolutionarytinder.models.jpa.auth.telegram.TelegramAuthEntity;
import ru.liga.prerevolutionarytinder.persistence.auth.telegram.TelegramAuthMapper;
import ru.liga.prerevolutionarytinder.repository.auth.globalUUID.GlobalUUIDRepository;
import ru.liga.prerevolutionarytinder.repository.auth.telegram.TelegramRegistrationRepository;
import ru.liga.prerevolutionarytinder.servicies.auth.RegistrationService;

@Service
public class TelegramRegistrationService implements RegistrationService<TelegramRegistrationInfo, TelegramAuthEntity> {
    private final TelegramRegistrationRepository registrationRepository;
    private final GlobalUUIDRepository globalUUIDRepository;
    private final TelegramAuthMapper telegramAuthMapper;

    @Autowired
    public TelegramRegistrationService(
            GlobalUUIDRepository globalUUIDRepository,
            TelegramRegistrationRepository registrationRepository,
            TelegramAuthMapper telegramAuthMapper) {
        this.globalUUIDRepository = globalUUIDRepository;

        this.registrationRepository = registrationRepository;
        this.telegramAuthMapper = telegramAuthMapper;
    }

    public TelegramAuthEntity create(TelegramRegistrationInfo registrationInfo) {
        var telegramAuthEntity = telegramAuthMapper.mapToEntity(registrationInfo);

        var globalId = globalUUIDRepository.save(new GlobalUUIDEntity());

        telegramAuthEntity.setGlobalUUIDEntity(globalId);
        return registrationRepository.save(telegramAuthEntity);
    }

    @Override
    public SourceType getApplicableType() {
        return SourceType.TELEGRAM;
    }
}
