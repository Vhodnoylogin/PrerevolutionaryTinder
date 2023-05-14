package ru.liga.prerevolutionarytinder.models.jpa.inner;

import jakarta.persistence.*;
import lombok.Data;
import ru.liga.prerevolutionarytinder.models.jpa.UserProfileEntity;

@Entity
@Table(name = "description")
@Data
public class DescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

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
