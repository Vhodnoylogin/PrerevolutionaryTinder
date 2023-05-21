package ru.liga.prerevolutionarytinder.models.jpa.profiles.inner;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;
import ru.liga.prerevolutionarytinder.models.jpa.profiles.UserProfileEntity;

@Entity
@Table(name = "description")
@Data
public class DescriptionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @JsonBackReference
    @OneToOne(mappedBy = "descriptionEntity")
    private UserProfileEntity userProfileEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DescriptionEntity that)) return false;

        return getText() != null ? getText().equals(that.getText()) : that.getText() == null;
    }

    @Override
    public int hashCode() {
        return getText() != null ? getText().hashCode() : 0;
    }
}
