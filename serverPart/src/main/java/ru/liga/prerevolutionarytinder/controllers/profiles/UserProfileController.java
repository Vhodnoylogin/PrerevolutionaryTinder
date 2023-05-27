package ru.liga.prerevolutionarytinder.controllers.profiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.models.UserProfile;

@Slf4j
@RestController
@RequestMapping("/api/user_profile")
public class UserProfileController {
//    private final UserProfileService userProfileService;
//
//    @Autowired
//    public UserProfileController(UserProfileService userProfileService) {
//        this.userProfileService = userProfileService;
//    }

    @PostMapping("/")
    public ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile) {
//    public UserProfileEntity createUserProfile(@RequestBody UserProfile userProfile) {
        // код для сохранения профиля на сервере
        log.info("{}", userProfile);
//        return userProfileService.create(userProfile);
        return new ResponseEntity<>("Profile created successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
        var profile = new UserProfile();
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
