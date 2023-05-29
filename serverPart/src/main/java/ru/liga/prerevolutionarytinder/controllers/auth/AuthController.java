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
//        this.telegramRegistrationService = null;
//    }
    public AuthController(TelegramRegistrationService telegramRegistrationService) {
        this.registrationServiceFactory = null;
        this.telegramRegistrationService = telegramRegistrationService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerNewUser(@RequestBody TelegramRegistrationInfo authPrincipleInfo) {
//        // код для сохранения профиля на сервере
//        if (telegramRegistrationService != null) {
//            var response = telegramRegistrationService.create(authPrincipleInfo);
//            return new ResponseEntity<>("Profile created successfully: " + response.toString(), HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("Input object is null: " + authPrincipleInfo.toString(), HttpStatus.NO_CONTENT);
//    }

    @PostMapping("/register")
    public <T extends AuthPrincipleInfo> ResponseEntity<String> registerNewUser(@RequestBody T authPrincipleInfo) {
        // код для сохранения профиля на сервере
        log.debug("{}", authPrincipleInfo);
//        if (telegramRegistrationService != null) {
//            var response = telegramRegistrationService.create((TelegramRegistrationInfo) authPrincipleInfo);
//            return new ResponseEntity<>("Profile created successfully: " + response.toString(), HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("Input object is null: " + authPrincipleInfo.toString(), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>("Input object =" + authPrincipleInfo.toString(), HttpStatus.OK);
    }
}
