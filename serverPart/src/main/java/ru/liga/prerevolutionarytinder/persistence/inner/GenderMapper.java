package ru.liga.prerevolutionarytinder.persistence.inner;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.liga.models.inner.Gender;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenderMapper {

    default String mapGenderToString(Gender gender) {
        return gender.name();
    }

    default Gender mapStringToGender(String gender) {
        return Gender.valueOf(gender);
    }
}
