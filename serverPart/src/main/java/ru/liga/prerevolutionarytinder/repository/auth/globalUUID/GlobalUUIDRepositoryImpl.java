package ru.liga.prerevolutionarytinder.repository.auth.globalUUID;

import jakarta.persistence.EntityManager;
import ru.liga.prerevolutionarytinder.models.jpa.auth.GlobalUUIDEntity;

public class GlobalUUIDRepositoryImpl implements GlobalUUIDCustomRepository {
    private final EntityManager entityManager;

    public GlobalUUIDRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public GlobalUUIDEntity generateGlobalID() {
        var globalId = new GlobalUUIDEntity();

        entityManager.persist(globalId);

//        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.refresh(globalId);

        return globalId;
    }
}
