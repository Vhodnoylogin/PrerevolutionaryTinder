package ru.liga.prerevolutionarytinder.test.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.liga.prerevolutionarytinder.test.mapper.classes.TestE;
import ru.liga.prerevolutionarytinder.test.mapper.classes.TestM;
import ru.liga.prerevolutionarytinder.test.mapper.mapper.TestMapper;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TestTestMapper {
    @InjectMocks
    private TestMapper testMapper = Mappers.getMapper(TestMapper.class);

    @Test
    void testMapToEntity() {
        // given
        var test = new TestM();
        test.setTezd("test");

        // when
        var testE = testMapper.toEntity(test);

        log.info("testing = {}", testE);
        log.info("expect = {}", test);

        // then
        assertThat(testE)
                .isNotNull();
        assertThat(testE.getTezd())
                .isEqualTo(test.getTezd());
    }

    @Test
    void testMapToDto() {
        // given
        var testE = new TestE();
        testE.setTezd("test");

        // when
        var test = testMapper.fromEntity(testE);

        log.info("testing = {}", test);
        log.info("expect = {}", testE);

        // then
        assertThat(test)
                .isNotNull();
        assertThat(test.getTezd())
                .isEqualTo(testE.getTezd());
    }
}
