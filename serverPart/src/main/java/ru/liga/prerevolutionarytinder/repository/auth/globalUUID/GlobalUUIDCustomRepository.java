package ru.liga.prerevolutionarytinder.repository.auth.globalUUID;

import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;

interface GlobalUUIDCustomRepository {
    GlobalUUIDEntity generateGlobalID();
}
