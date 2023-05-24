package ru.liga.prerevolutionarytinder.servicies.auth.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.telegram.TelegramAuthEntity;
import ru.liga.prerevolutionarytinder.persistence.auth.telegram.TelegramAuthMapper;
import ru.liga.prerevolutionarytinder.repository.auth.telegram.TelegramRegistrationRepository;
import ru.liga.prerevolutionarytinder.servicies.auth.RegistrationService;

@Service
//@Qualifier("telegramRegistrationService")
public class TelegramRegistrationService implements RegistrationService<TelegramRegistrationInfo, TelegramAuthEntity> {
    private final TelegramRegistrationRepository registrationRepository;
    private final TelegramAuthMapper telegramAuthMapper;


    @Autowired
    public TelegramRegistrationService(TelegramRegistrationRepository registrationRepository, TelegramAuthMapper telegramAuthMapper) {
        this.registrationRepository = registrationRepository;
        this.telegramAuthMapper = telegramAuthMapper;
    }

    @Override
    public TelegramAuthEntity create(TelegramRegistrationInfo authPrincipleInfo) {
        var telegramAuthEntity = telegramAuthMapper.mapToEntity(authPrincipleInfo);
        return registrationRepository.save(telegramAuthEntity);
    }

    @Override
    public Class<? extends AuthPrincipleInfo> getApplicableType() {
        return TelegramRegistrationInfo.class;
    }
}
