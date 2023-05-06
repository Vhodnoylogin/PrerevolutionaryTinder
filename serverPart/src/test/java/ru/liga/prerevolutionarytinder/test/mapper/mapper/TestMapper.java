package ru.liga.prerevolutionarytinder.test.mapper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.prerevolutionarytinder.test.mapper.classes.TestE;
import ru.liga.prerevolutionarytinder.test.mapper.classes.TestM;

@Mapper(componentModel = "spring")
public interface TestMapper {
//    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    @Mapping(source = "tezd", target = "tezd")
    TestE toEntity(TestM testM);

    @Mapping(source = "tezd", target = "tezd")
    TestM fromEntity(TestE testE);
}
