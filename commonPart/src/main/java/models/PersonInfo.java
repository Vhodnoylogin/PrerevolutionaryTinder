package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonInfo implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
}
