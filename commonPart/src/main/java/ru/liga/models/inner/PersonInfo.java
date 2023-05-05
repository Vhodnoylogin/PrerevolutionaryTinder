package ru.liga.models.inner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfo {
    private String firstName;
    private String lastName;
    private Gender gender;
}
