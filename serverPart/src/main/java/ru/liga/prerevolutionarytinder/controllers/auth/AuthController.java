package ru.liga.prerevolutionarytinder.controllers.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.servicies.auth.RegistrationServiceFactory;
import ru.liga.prerevolutionarytinder.servicies.auth.telegram.TelegramRegistrationService;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final RegistrationServiceFactory registrationServiceFactory;
    private final TelegramRegistrationService telegramRegistrationService;

    @Autowired
//    public AuthController(RegistrationServiceFactory registrationServiceFactory) {
//        this.registrationServiceFactory = registrationServiceFactory;
//    }
    public AuthController(TelegramRegistrationService telegramRegistrationService) {
        this.registrationServiceFactory = null;
        this.telegramRegistrationService = telegramRegistrationService;
    }

    @PostMapping("/register")
//    public ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile) {
//    public ResponseEntity<String> createUserProfile(@RequestBody AuthPrincipleInfo authPrincipleInfo) {
    public ResponseEntity<String> createUserProfile(@RequestBody TelegramRegistrationInfo authPrincipleInfo) {
        // код для сохранения профиля на сервере
        log.info("{}", authPrincipleInfo);
//        var res = registrationServiceFactory.createRegistrationService(authPrincipleInfo);
//        var response = res.create(authPrincipleInfo);

        var response = telegramRegistrationService.create(authPrincipleInfo);
//        return userProfileService.create(userProfile);
        return new ResponseEntity<>("Profile created successfully: " + response.toString(), HttpStatus.OK);
    }
}
