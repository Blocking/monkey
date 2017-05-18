package com.look.monkey.repository.Abstract;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

import com.look.monkey.entity.base.Identifiable;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.HQLTemplates;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * 
 * @author zhangxy
 * jpa扩展 使用querydsl
 * @param <T> 实体类型
 */
public abstract class AbstractRepository<T extends Identifiable> implements Repository<T, Long> {

    @Autowired
    protected Provider<EntityManager> em;

    @SuppressWarnings("hiding")
    protected <T> JPAQuery<T> selectFrom(final EntityPath<T> entity) {
        return this.select(entity).from(entity);
    }

    @SuppressWarnings("hiding")
    protected <T> JPAQuery<T> select(final Expression<T> select) {
        return new JPAQuery<>(this.em.get(), HQLTemplates.DEFAULT).select(select);
    }

    protected JPADeleteClause delete(final EntityPath<?> entity) {
        return new JPADeleteClause(this.em.get(), entity, HQLTemplates.DEFAULT);
    }

    protected void detach(final Object entity) {
        this.em.get().detach(entity);
    }

    protected <E> E find(final Class<E> type, final Long id) {
        return this.em.get().find(type, id);
    }

    protected void persist(final Object entity) {
        this.em.get().persist(entity);
    }

    protected <E> E merge(final E entity) {
        return this.em.get().merge(entity);
    }

    protected <E extends Identifiable> E persistOrMerge(final E entity) {
        if (entity.getId() != null) {
            return this.merge(entity);
        }
        this.persist(entity);
        return entity;
    }

    protected void remove(final Object entity) {
        this.em.get().remove(entity);
    }


}
