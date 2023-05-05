package ru.liga.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.liga.models.UserProfile;
import ru.liga.models.inner.Description;
import ru.liga.models.inner.Gender;
import ru.liga.models.inner.PersonInfo;
import ru.liga.prerevolutionarytinder.models.jpa.UserProfileEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.PersonInfoEntity;
import ru.liga.prerevolutionarytinder.persistence.UserProfileMapper;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserProfileMapperTest {
    @Autowired
    private UserProfileMapper userProfileMapper;

    @Test
    public void testMapUserProfileToUserProfileEntity() {
        UserProfile userProfile = new UserProfile();
        userProfile.setPersonInfo(new PersonInfo("John", "Doe", Gender.MALE));
        userProfile.setDescription(new Description("Some description"));
        userProfile.setLookingFor(Arrays.asList(Gender.FEMALE, Gender.OTHER));

        UserProfileEntity userProfileEntity = userProfileMapper.toUserProfileEntity(userProfile);

        var descE = new DescriptionEntity();
        descE.setText(userProfile.getDescription().getText());

        var personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setFirstName(userProfile.getPersonInfo().getFirstName());
        personInfoEntity.setLastName(userProfile.getPersonInfo().getLastName());
        personInfoEntity.setGender(userProfile.getPersonInfo().getGender());

        var genderFE = new GenderEntity();
        genderFE.setGender(Gender.FEMALE);
        var genderOE = new GenderEntity();
        genderOE.setGender(Gender.OTHER);

        var testUserProfileEntity = new UserProfileEntity();
        testUserProfileEntity.setDescription(descE);
        testUserProfileEntity.setPersonInfo(personInfoEntity);
        testUserProfileEntity.setLookingFor(Arrays.asList(genderFE, genderOE));

        assertThat(userProfileEntity)
                .isEqualTo(testUserProfileEntity);


//        assertEquals(userProfile.getPersonInfo().getFirstName(), userProfileEntity.getPersonInfo().getFirstName());
//        assertEquals(userProfile.getPersonInfo().getLastName(), userProfileEntity.getPersonInfo().getLastName());
//        assertEquals(userProfile.getPersonInfo().getGender().name(), userProfileEntity.getPersonInfo().getGender());
//        assertEquals(userProfile.getDescription().getText(), userProfileEntity.getDescription().getText());
//        assertEquals(userProfile.getLookingFor().size(), userProfileEntity.getLookingFor().size());
//        assertTrue(userProfile.getLookingFor().containsAll(userProfileEntity.getLookingFor()));
    }

//    @Test
//    public void testMapUserProfileEntityToUserProfile() {
//        UserProfileEntity userProfileEntity = new UserProfileEntity();
//        userProfileEntity.setId(1L);
//        userProfileEntity.setPersonInfo(new PersonInfoEntity("John", "Doe", "MALE"));
//        userProfileEntity.setDescription(new DescriptionEntity("Some description"));
//        userProfileEntity.setLookingFor(Arrays.asList(new GenderEntity(1L, "FEMALE"), new GenderEntity(2L, "OTHER")));
//
//        UserProfile userProfile = userProfileMapper.userProfileEntityToUserProfile(userProfileEntity);
//
//        assertEquals(userProfileEntity.getPersonInfo().getFirstName(), userProfile.getPersonInfo().getFirstName());
//        assertEquals(userProfileEntity.getPersonInfo().getLastName(), userProfile.getPersonInfo().getLastName());
//        assertEquals(Gender.valueOf(userProfileEntity.getPersonInfo().getGender()), userProfile.getPersonInfo().getGender());
//        assertEquals(userProfileEntity.getDescription().getText(), userProfile.getDescription().getText());
//        assertEquals(userProfileEntity.getLookingFor().size(), userProfile.getLookingFor().size());
//        assertTrue(userProfileEntity.getLookingFor().stream()
//                .map(GenderEntity::getName)
//                .map(Gender::valueOf)
//                .collect(Collectors.toList())
//                .containsAll(userProfile.getLookingFor()));
//    }
}
