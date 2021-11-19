package com.snourian.example.dynquery.repository;

import com.querydsl.core.types.Predicate;
import com.snourian.example.dynquery.domain.Department;
import com.snourian.micronaut.querydsl.QuerydslPredicateExecutor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class DepartmentRepository implements JpaRepository<Department, Long>,
        QuerydslPredicateExecutor<Department> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }
}
