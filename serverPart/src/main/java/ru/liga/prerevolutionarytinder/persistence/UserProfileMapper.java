package ru.liga.prerevolutionarytinder.persistence;

import ru.liga.models.UserProfile;
import ru.liga.models.inner.Description;
import ru.liga.models.inner.Gender;
import ru.liga.models.inner.PersonInfo;
import ru.liga.prerevolutionarytinder.models.jpa.UserProfileEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.PersonInfoEntity;

import java.util.function.Function;

public class UserProfileMapper {
    public UserProfileEntity mapToEntity(UserProfile userProfile) {
        var userProfileEntity = new UserProfileEntity();

        var descriptionEntity = new DescriptionEntity();
        descriptionEntity.setText(userProfile.getDescription().getText());


        var personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setGender(userProfile.getPersonInfo().getGender());
        personInfoEntity.setFirstName(userProfile.getPersonInfo().getFirstName());
        personInfoEntity.setLastName(userProfile.getPersonInfo().getLastName());

        Function<Gender, GenderEntity> genderGenderEntityFunction = x -> {
            var genderEntity = new GenderEntity();
            genderEntity.setUserProfile(userProfileEntity);
            genderEntity.setGender(x);
            return genderEntity;
        };
        var genderEntityList = userProfile.getLookingFor()
                .stream()
                .map(genderGenderEntityFunction)
                .toList();


        userProfileEntity.setLookingFor(genderEntityList);
        userProfileEntity.setDescription(descriptionEntity);
        userProfileEntity.setPersonInfo(personInfoEntity);

        return userProfileEntity;
    }

    public UserProfile mapToDto(UserProfileEntity userProfileEntity) {
        var userProfile = new UserProfile();

        var personInfo = new PersonInfo();
        personInfo.setFirstName(userProfileEntity.getPersonInfo().getFirstName());
        personInfo.setLastName(userProfileEntity.getPersonInfo().getLastName());
        personInfo.setGender(userProfileEntity.getPersonInfo().getGender());

        var description = new Description();
        description.setText(userProfileEntity.getDescription().getText());

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
