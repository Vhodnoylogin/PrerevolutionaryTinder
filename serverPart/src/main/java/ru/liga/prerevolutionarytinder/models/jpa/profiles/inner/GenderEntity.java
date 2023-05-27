package ru.liga.prerevolutionarytinder.models.jpa.profiles.inner;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import ru.liga.models.inner.Gender;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;

//@Entity
@Table(name = "gender_list")
@Data
//@AllArgsConstructor
public class GenderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfileEntity userProfileEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenderEntity that)) return false;

        return getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        return getGender().hashCode();
    }
}
