package ru.liga.prerevolutionarytinder.persistence.inner;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.liga.models.inner.Description;
import ru.liga.prerevolutionarytinder.models.jpa.inner.DescriptionEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DescriptionMapper {
    DescriptionEntity toEntity(Description description);

    Description toDto(DescriptionEntity descriptionEntity);
}
