package ru.liga.prerevolutionarytinder.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.models.UserProfile;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;
import ru.liga.prerevolutionarytinder.persistence.UserProfileMapper;
import ru.liga.prerevolutionarytinder.repository.UserProfileRepository;

@Service
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
