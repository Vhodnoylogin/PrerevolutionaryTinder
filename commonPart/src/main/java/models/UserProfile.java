package models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserProfile implements Serializable {
    private PersonInfo personInfo;
    private String description;
    private List<Gender> lookingFor;
}
