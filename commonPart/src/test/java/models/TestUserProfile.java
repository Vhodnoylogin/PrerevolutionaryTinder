package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class TestUserProfile {

    public static UserProfile profile;

    @BeforeAll
    public static void init(){
        profile = new UserProfile();
        profile.setDescription("TEST PROFILE");
        profile.setLookingFor(List.of(Gender.MALE));

        var userInfo = new PersonInfo();
        profile.setPersonInfo(userInfo);

        userInfo.setFirstName("QQL");
        userInfo.setLastName("QWERTY");
        userInfo.setGender(Gender.FEMALE);
    }

    @SneakyThrows
    @Test
    void testUserProfile(){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(profile);

        log.info("{}", json);
    }
}