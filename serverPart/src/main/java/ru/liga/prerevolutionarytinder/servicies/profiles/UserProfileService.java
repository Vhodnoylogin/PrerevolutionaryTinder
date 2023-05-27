package ru.liga.prerevolutionarytinder.servicies.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import ru.liga.models.UserProfile;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;
import ru.liga.prerevolutionarytinder.persistence.UserProfileMapper;
import ru.liga.prerevolutionarytinder.repository.profiles.UserProfileRepository;

//@Service
public class UserProfileService {
    private final UserProfileMapper userProfileMapper;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileMapper userProfileMapper, UserProfileRepository userProfileRepository) {
        this.userProfileMapper = userProfileMapper;
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfileEntity create(UserProfile userProfile) {
        UserProfileEntity userProfileEntity = userProfileMapper.mapToEntity(userProfile);
        return userProfileRepository.save(userProfileEntity);
//        return userProfileEntity;
    }
}
