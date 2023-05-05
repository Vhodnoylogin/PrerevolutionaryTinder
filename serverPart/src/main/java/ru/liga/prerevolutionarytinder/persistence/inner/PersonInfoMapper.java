package ru.liga.prerevolutionarytinder.persistence.inner;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.liga.models.inner.PersonInfo;
import ru.liga.prerevolutionarytinder.models.jpa.inner.PersonInfoEntity;

@Mapper(componentModel = "spring", uses = {GenderMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonInfoMapper {
    @Mapping(target = "gender", source = "gender")
    PersonInfoEntity toEntity(PersonInfo personInfo);

    @InheritInverseConfiguration
    PersonInfo toModel(PersonInfoEntity entity);
}
