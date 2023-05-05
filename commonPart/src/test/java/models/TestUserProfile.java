package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.liga.models.UserProfile;
import ru.liga.models.inner.Description;
import ru.liga.models.inner.Gender;
import ru.liga.models.inner.PersonInfo;

import java.util.List;

@Slf4j
public class TestUserProfile {

    public static UserProfile profile;

    @BeforeAll
    public static void init() {
        var userInfo = new PersonInfo();
        userInfo.setFirstName("QQL");
        userInfo.setLastName("QWERTY");
        userInfo.setGender(Gender.FEMALE);

        var desc = new Description();
        desc.setText("TEST PROFILE");

        profile = new UserProfile();
        profile.setDescription(desc);
        profile.setLookingFor(List.of(Gender.MALE));

        profile.setPersonInfo(userInfo);


    }

    @SneakyThrows
    @Test
    void testUserProfile(){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(profile);

        log.info("{}", json);
    }
}