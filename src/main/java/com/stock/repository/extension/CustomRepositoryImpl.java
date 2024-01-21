package com.stock.repository.extension;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRepositoryImpl<T, ID> implements CustomRepository<T, ID> {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public <S extends T> List<S> batchInsert(Iterable<S> entities) {
        Assert.notNull(entities, "Entities must not be null");

        List<S> result = new ArrayList<>();
        for (S entity : entities) {
            result.add(entity);
            entityManager.persist(entity);
        }

        return result;
    }
}
