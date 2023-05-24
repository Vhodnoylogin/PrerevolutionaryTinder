package ru.liga.prerevolutionarytinder.persistence.auth.telegram;

import org.springframework.stereotype.Component;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.telegram.TelegramAuthEntity;
import ru.liga.prerevolutionarytinder.persistence.common.DtoEntityMapper;

@Component
public class TelegramAuthMapper implements DtoEntityMapper<TelegramRegistrationInfo, TelegramAuthEntity> {
    @Override
    public TelegramAuthEntity mapToEntity(TelegramRegistrationInfo dto) {
        var telegramAuthEntity = new TelegramAuthEntity();
        telegramAuthEntity.setUserId(dto.getUserId());
        return telegramAuthEntity;
    }

    @Override
    public TelegramRegistrationInfo mapToDto(TelegramAuthEntity entity) {
        var registrationInfo = new TelegramRegistrationInfo();
        registrationInfo.setUserId(registrationInfo.getUserId());
        return registrationInfo;
    }
}
