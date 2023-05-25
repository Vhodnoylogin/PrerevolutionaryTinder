package ru.liga.prerevolutionarytinder.servicies.auth;

import org.springframework.stereotype.Service;
import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.BaseAuthEntity;

import java.util.List;

@Service
public class RegistrationServiceFactory {
    private final List<RegistrationService<AuthPrincipleInfo, BaseAuthEntity>> registrationServices;

    public RegistrationServiceFactory(List<RegistrationService<AuthPrincipleInfo, BaseAuthEntity>> registrationServices) {
        this.registrationServices = registrationServices;
    }

    public RegistrationService<AuthPrincipleInfo, BaseAuthEntity> createRegistrationService(AuthPrincipleInfo authPrincipleInfo) {
        for (RegistrationService<AuthPrincipleInfo, BaseAuthEntity> registrationService : registrationServices) {
            if (isServiceApplicable(registrationService, authPrincipleInfo)) {
                return registrationService;
            }
        }
        throw new IllegalArgumentException("Unsupported AuthPrincipleInfo type");
    }

    private boolean isServiceApplicable(RegistrationService<AuthPrincipleInfo, BaseAuthEntity> registrationService, AuthPrincipleInfo authPrincipleInfo) {
        var serviceType = registrationService.getApplicableType();
        return serviceType.equals(authPrincipleInfo.getSourceType());
    }
}
