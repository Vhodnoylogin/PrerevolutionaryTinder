package ru.liga.prerevolutionarytinder.models.jpa.profiles.inner;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import ru.liga.models.inner.Gender;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;

@Entity
@Table(name = "person_info")
@Data
public class PersonInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonBackReference
    @OneToOne(mappedBy = "personInfoEntity")
    private UserProfileEntity userProfileEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonInfoEntity that)) return false;

        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        return getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        return result;
    }
}
