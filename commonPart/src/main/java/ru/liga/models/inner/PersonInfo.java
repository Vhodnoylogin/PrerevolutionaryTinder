package ru.liga.models.inner;

import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class PersonInfo {
    private String firstName;
    private String lastName;
    private Gender gender;
}
