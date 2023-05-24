package ru.liga.prerevolutionarytinder.servicies.auth;

import org.springframework.stereotype.Service;
import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.prerevolutionarytinder.models.jpa.auth.AnyAuthEntity;

import java.util.List;

@Service
public class RegistrationServiceFactory {
    private final List<RegistrationService<AuthPrincipleInfo, AnyAuthEntity>> registrationServices;

    public RegistrationServiceFactory(List<RegistrationService<AuthPrincipleInfo, AnyAuthEntity>> registrationServices) {
        this.registrationServices = registrationServices;
    }

    public RegistrationService<AuthPrincipleInfo, AnyAuthEntity> createRegistrationService(AuthPrincipleInfo authPrincipleInfo) {
        for (RegistrationService<AuthPrincipleInfo, AnyAuthEntity> registrationService : registrationServices) {
            if (isServiceApplicable(registrationService, authPrincipleInfo)) {
                return registrationService;
            }
        }
        throw new IllegalArgumentException("Unsupported AuthPrincipleInfo type");
    }

    private boolean isServiceApplicable(RegistrationService<AuthPrincipleInfo, AnyAuthEntity> registrationService, AuthPrincipleInfo authPrincipleInfo) {
        Class<? extends AuthPrincipleInfo> serviceType = registrationService.getApplicableType();
        return serviceType.isInstance(authPrincipleInfo);
    }
}
