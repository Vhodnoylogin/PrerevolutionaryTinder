package ru.liga.prerevolutionarytinder.controllers.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.models.auth.AuthPrincipleInfo;
import ru.liga.prerevolutionarytinder.servicies.auth.RegistrationServiceFactory;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final RegistrationServiceFactory registrationServiceFactory;

    @Autowired
    public AuthController(RegistrationServiceFactory registrationServiceFactory) {
        this.registrationServiceFactory = registrationServiceFactory;
    }

    @PostMapping("/register")
//    public ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile) {
    public ResponseEntity<String> createUserProfile(@RequestBody AuthPrincipleInfo authPrincipleInfo) {
        // код для сохранения профиля на сервере
        log.info("{}", authPrincipleInfo);
        var res = registrationServiceFactory.createRegistrationService(authPrincipleInfo);
        var tr = res.create(authPrincipleInfo);
//        return userProfileService.create(userProfile);
        return new ResponseEntity<>("Profile created successfully: " + tr.toString(), HttpStatus.OK);
    }
}
