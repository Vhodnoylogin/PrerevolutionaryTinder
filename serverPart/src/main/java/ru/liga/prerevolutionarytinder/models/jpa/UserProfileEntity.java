package ru.liga.prerevolutionarytinder.models.jpa;


import jakarta.persistence.*;
import lombok.Data;
import ru.liga.prerevolutionarytinder.models.jpa.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.PersonInfoEntity;

import java.util.List;

@Entity
@Table(name = "user_profile")
@Data
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_info_id", referencedColumnName = "id")
    private PersonInfoEntity personInfoEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private DescriptionEntity descriptionEntity;

    @OneToMany(mappedBy = "userProfileEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GenderEntity> lookingFor;
}
