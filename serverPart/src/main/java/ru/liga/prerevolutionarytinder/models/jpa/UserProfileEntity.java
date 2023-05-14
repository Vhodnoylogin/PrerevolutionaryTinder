package ru.liga.prerevolutionarytinder.models.jpa;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import ru.liga.prerevolutionarytinder.models.jpa.inner.DescriptionEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.GenderEntity;
import ru.liga.prerevolutionarytinder.models.jpa.inner.PersonInfoEntity;

import java.util.List;

@Entity
//@MappedSuperclass
@Data
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_info_id", referencedColumnName = "id")
    private PersonInfoEntity personInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private DescriptionEntity description;

    @OneToMany(mappedBy = "UserProfileEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GenderEntity> lookingFor;
}
