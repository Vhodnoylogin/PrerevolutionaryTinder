package ru.liga.prerevolutionarytinder.persistence;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.liga.models.UserProfile;
import ru.liga.models.inner.Description;
import ru.liga.models.inner.Gender;
import ru.liga.models.inner.PersonInfo;
import ru.liga.prerevolutionarytinder.models.jpa.UserProfileEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.PersonInfoEntity;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserProfileMapperTest {
    //    @Autowired
//    private UserProfileMapper userProfileMapper;
//    @InjectMocks
//    private UserProfileMapper userProfileMapper = Mappers.getMapper(UserProfileMapper.class);
    private static UserProfileMapper userProfileMapper;

    @BeforeAll
    public static void init() {
        userProfileMapper = new UserProfileMapper();
    }

    @Test
    public void testMapUserProfileToUserProfileEntity() {
        var userProfile = new UserProfile();

        var personInfo = new PersonInfo();
        personInfo.setGender(Gender.MALE);
        personInfo.setLastName("Doe");
        personInfo.setFirstName("John");

        var description = new Description();
        description.setText("Some description");

        var genderList = Arrays.asList(Gender.FEMALE, Gender.OTHER);

        userProfile.setLookingFor(genderList);
        userProfile.setPersonInfo(personInfo);
        userProfile.setDescription(description);

        var userProfileEntity = userProfileMapper.mapToEntity(userProfile);

        //

        var testUserProfileEntity = new UserProfileEntity();

        var personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setFirstName(userProfile.getPersonInfo().getFirstName());
        personInfoEntity.setLastName(userProfile.getPersonInfo().getLastName());
        personInfoEntity.setGender(userProfile.getPersonInfo().getGender());

        var descriptionE = new DescriptionEntity();
        descriptionE.setText(userProfile.getDescription().getText());

        var genderFE = new GenderEntity();
        genderFE.setGender(Gender.FEMALE);
        genderFE.setUserProfile(testUserProfileEntity);
        var genderOE = new GenderEntity();
        genderOE.setGender(Gender.OTHER);
        genderOE.setUserProfile(testUserProfileEntity);
        var genderEList = Arrays.asList(genderFE, genderOE);

        testUserProfileEntity.setDescription(descriptionE);
        testUserProfileEntity.setPersonInfo(personInfoEntity);
        testUserProfileEntity.setLookingFor(genderEList);

        assertThat(userProfileEntity)
                .isEqualTo(testUserProfileEntity);

//        assertEquals(userProfile.getPersonInfo().getFirstName(), userProfileEntity.getPersonInfo().getFirstName());
//        assertEquals(userProfile.getPersonInfo().getLastName(), userProfileEntity.getPersonInfo().getLastName());
//        assertEquals(userProfile.getPersonInfo().getGender().name(), userProfileEntity.getPersonInfo().getGender());
//        assertEquals(userProfile.getDescription().getText(), userProfileEntity.getDescription().getText());
//        assertEquals(userProfile.getLookingFor().size(), userProfileEntity.getLookingFor().size());
//        assertTrue(userProfile.getLookingFor().containsAll(userProfileEntity.getLookingFor()));
    }

    @Test
    public void testMapUserProfileEntityToUserProfile() {
        var userProfileE = new UserProfileEntity();

        var personInfoE = new PersonInfoEntity();
        personInfoE.setGender(Gender.MALE);
        personInfoE.setLastName("Doe");
        personInfoE.setFirstName("John");

        var descriptionE = new DescriptionEntity();
        descriptionE.setText("Some description");

        var genderFE = new GenderEntity();
        genderFE.setGender(Gender.FEMALE);
        genderFE.setUserProfile(userProfileE);
        var genderOE = new GenderEntity();
        genderOE.setGender(Gender.OTHER);
        genderOE.setUserProfile(userProfileE);
        var genderEList = Arrays.asList(genderFE, genderOE);

        userProfileE.setPersonInfo(personInfoE);
        userProfileE.setDescription(descriptionE);
        userProfileE.setLookingFor(genderEList);

        var userProfile = userProfileMapper.mapToDto(userProfileE);

        //

        var testUserProfile = new UserProfile();

        var personInfo = new PersonInfo();
        personInfo.setGender(userProfileE.getPersonInfo().getGender());
        personInfo.setLastName(userProfileE.getPersonInfo().getLastName());
        personInfo.setFirstName(userProfileE.getPersonInfo().getFirstName());

        var description = new Description();
        description.setText(userProfileE.getDescription().getText());

        var genderList = userProfileE.getLookingFor()
                .stream()
                .map(GenderEntity::getGender)
                .toList();

        testUserProfile.setPersonInfo(personInfo);
        testUserProfile.setDescription(description);
        testUserProfile.setLookingFor(genderList);

        assertThat(userProfile)
                .isEqualTo(testUserProfile);
    }
}
