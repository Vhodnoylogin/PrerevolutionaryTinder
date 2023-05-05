package ru.liga.prerevolutionarytinder.models.jpa.inner;

import jakarta.persistence.*;
import lombok.Data;
import ru.liga.models.inner.Gender;
import ru.liga.prerevolutionarytinder.models.jpa.UserProfileEntity;

@Entity
@Table(name = "gender_list")
@Data
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfileEntity userProfile;
}
