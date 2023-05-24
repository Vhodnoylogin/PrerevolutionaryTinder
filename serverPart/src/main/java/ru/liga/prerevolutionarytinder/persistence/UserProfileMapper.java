package ru.liga.prerevolutionarytinder.persistence;

import org.springframework.stereotype.Component;
import ru.liga.models.UserProfile;
import ru.liga.models.inner.Description;
import ru.liga.models.inner.Gender;
import ru.liga.models.inner.PersonInfo;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.inner.PersonInfoEntity;
import ru.liga.prerevolutionarytinder.persistence.common.DtoEntityMapper;

import java.util.function.Function;

@Component
public class UserProfileMapper implements DtoEntityMapper<UserProfile, UserProfileEntity> {
    public UserProfileEntity mapToEntity(UserProfile userProfile) {
        var userProfileEntity = new UserProfileEntity();

        var descriptionEntity = new DescriptionEntity();
        descriptionEntity.setText(userProfile.getDescription().getText());
        descriptionEntity.setUserProfileEntity(userProfileEntity);


        var personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setGender(userProfile.getPersonInfo().getGender());
        personInfoEntity.setFirstName(userProfile.getPersonInfo().getFirstName());
        personInfoEntity.setLastName(userProfile.getPersonInfo().getLastName());
        personInfoEntity.setUserProfileEntity(userProfileEntity);


        Function<Gender, GenderEntity> genderGenderEntityFunction = x -> {
            var genderEntity = new GenderEntity();
            genderEntity.setUserProfileEntity(userProfileEntity);
            genderEntity.setGender(x);
            return genderEntity;
        };
        var genderEntityList = userProfile.getLookingFor()
                .stream()
                .map(genderGenderEntityFunction)
                .toList();


        userProfileEntity.setLookingFor(genderEntityList);
        userProfileEntity.setDescriptionEntity(descriptionEntity);
        userProfileEntity.setPersonInfoEntity(personInfoEntity);

        return userProfileEntity;
    }

    public UserProfile mapToDto(UserProfileEntity userProfileEntity) {
        var userProfile = new UserProfile();

        var personInfo = new PersonInfo();
        personInfo.setFirstName(userProfileEntity.getPersonInfoEntity().getFirstName());
        personInfo.setLastName(userProfileEntity.getPersonInfoEntity().getLastName());
        personInfo.setGender(userProfileEntity.getPersonInfoEntity().getGender());

        var description = new Description();
        description.setText(userProfileEntity.getDescriptionEntity().getText());

        var genderList = userProfileEntity.getLookingFor()
                .stream()
                .map(GenderEntity::getGender)
                .toList();

        userProfile.setDescription(description);
        userProfile.setPersonInfo(personInfo);
        userProfile.setLookingFor(genderList);

        return userProfile;
    }
}
