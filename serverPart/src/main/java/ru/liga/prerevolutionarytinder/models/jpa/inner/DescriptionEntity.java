package ru.liga.prerevolutionarytinder.models.jpa.inner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "description")
@Data
public class DescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "user_profile_id")
//    private UserProfileEntity userProfile;

    private String text;
}
