package ru.liga.prerevolutionarytinder.controllers.auth.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.models.auth.telegram.TelegramRegistrationInfo;
import ru.liga.prerevolutionarytinder.servicies.auth.telegram.TelegramRegistrationService;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class TelegramAuthController {
    private final TelegramRegistrationService telegramRegistrationService;

    @Autowired
    public TelegramAuthController(TelegramRegistrationService telegramRegistrationService) {
        this.telegramRegistrationService = telegramRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody TelegramRegistrationInfo authPrincipleInfo) {
        // код для сохранения профиля на сервере
        if (telegramRegistrationService != null) {
            var response = telegramRegistrationService.create(authPrincipleInfo);
            return new ResponseEntity<>("Profile created successfully: " + response.toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Input object is null: " + authPrincipleInfo.toString(), HttpStatus.NO_CONTENT);
    }

}
