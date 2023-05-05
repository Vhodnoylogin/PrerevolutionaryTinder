package ru.liga.prerevolutionarytinder.persistence;

import org.mapstruct.Mapper;
import ru.liga.models.UserProfile;
import ru.liga.prerevolutionarytinder.models.jpa.UserProfileEntity;
import ru.liga.prerevolutionarytinder.persistence.inner.DescriptionMapper;
import ru.liga.prerevolutionarytinder.persistence.inner.GenderMapper;
import ru.liga.prerevolutionarytinder.persistence.inner.PersonInfoMapper;

@Mapper(componentModel = "spring", uses = {PersonInfoMapper.class, DescriptionMapper.class, GenderMapper.class})
public interface UserProfileMapper {

    UserProfile toUserProfile(UserProfileEntity entity);

    UserProfileEntity toUserProfileEntity(UserProfile dto);

}
