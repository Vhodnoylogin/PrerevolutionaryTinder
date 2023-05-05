package ru.liga.prerevolutionarytinder.models.jpa.inner;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import ru.liga.models.inner.Gender;

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
}
