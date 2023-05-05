package ru.liga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.models.inner.Description;
import ru.liga.models.inner.Gender;
import ru.liga.models.inner.PersonInfo;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private PersonInfo personInfo;
    private Description description;
    private List<Gender> lookingFor;
}
