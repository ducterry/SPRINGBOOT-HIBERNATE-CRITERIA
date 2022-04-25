package com.ndangducbn.hibernate.dao;

import com.ndangducbn.hibernate.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

@Repository
@Slf4j
public abstract class AbstractDAO<T extends BaseEntity> {

    @Autowired
    private EntityManager entityManager;

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public Session currentSession() {
        return entityManager.unwrap(Session.class);
    }

    public Criteria getCriteria() {
        return currentSession().createCriteria(entityClass);

    }
}