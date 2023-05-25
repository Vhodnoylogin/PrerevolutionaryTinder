package ru.liga.prerevolutionarytinder.servicies.auth;

import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.models.auth.SourceType;
import ru.liga.prerevolutionarytinder.models.jpa.auth.BaseAuthEntity;

public interface RegistrationService<T extends AuthPrincipleInfo, R extends BaseAuthEntity> {
    R create(T authPrincipleInfo);

    SourceType getApplicableType();
}
