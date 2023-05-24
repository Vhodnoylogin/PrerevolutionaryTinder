package ru.liga.prerevolutionarytinder.servicies.auth;

import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.AnyAuthEntity;

public interface RegistrationService<T extends AuthPrincipleInfo, R extends AnyAuthEntity> {
    R create(T authPrincipleInfo);

    Class<? extends AuthPrincipleInfo> getApplicableType();
}
