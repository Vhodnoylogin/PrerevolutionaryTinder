package ru.liga.prerevolutionarytinder.persistence.common;

public interface DtoEntityMapper<D, E> {
    E mapToEntity(D dto);

    D mapToDto(E entity);
}
