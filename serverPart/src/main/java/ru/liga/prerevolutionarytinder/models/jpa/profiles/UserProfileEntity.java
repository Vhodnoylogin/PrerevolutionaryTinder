package ru.liga.prerevolutionarytinder.models.jpa.profiles;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.inner.PersonInfoEntity;

import java.util.List;

//@Entity
@Table(name = "user_profile")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserProfileEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_info_id", referencedColumnName = "id")
    private PersonInfoEntity personInfoEntity;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private DescriptionEntity descriptionEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "userProfileEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GenderEntity> lookingFor;
}
