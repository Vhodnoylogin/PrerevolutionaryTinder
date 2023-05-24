package ru.liga.prerevolutionarytinder.persistence.auth;

import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.models.auth.SourceType;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.AnyAuthEntity;
import ru.liga.prerevolutionarytinder.persistence.auth.telegram.TelegramAuthMapper;
import ru.liga.prerevolutionarytinder.persistence.common.DtoEntityMapper;

public abstract class CommonAuthMapper implements DtoEntityMapper<AuthPrincipleInfo, AnyAuthEntity> {

    @Override
    public AnyAuthEntity mapToEntity(AuthPrincipleInfo dto) {
        var dtoSourceType = dto.getSourceType();

        if (dtoSourceType == SourceType.TELEGRAM) {
            var mapper = new TelegramAuthMapper();
            return mapper.mapToEntity((TelegramRegistrationInfo) dto);
        }

        return null;
    }

    @Override
    public AuthPrincipleInfo mapToDto(AnyAuthEntity entity) {
        return null;
    }
}
