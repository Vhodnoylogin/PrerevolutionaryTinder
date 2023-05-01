package prerevolutionarytinder.controllers;

import lombok.extern.slf4j.Slf4j;
import models.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user_profile")
public class UserProfileController {
    @PostMapping("/")
    public ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile) {
        // код для сохранения профиля на сервере
        log.info("{}", userProfile);
        return new ResponseEntity<>("Profile created successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
        var profile = new UserProfile();
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
