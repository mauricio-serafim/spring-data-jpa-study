package com.sigma.study.spring_data_jpa.repository.impl;

import com.sigma.study.spring_data_jpa.repository.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;

public class CustomRepositoryImpl<T, I extends Serializable> extends SimpleJpaRepository<T, I>
        implements CustomRepository<T, I> {

    @PersistenceContext
    private final EntityManager entityManager;

    public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    @Override
    public void refresh(T entity) {
        entityManager.refresh(entity);
    }
}
