package com.staybingo.common.repositories;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseCRUDRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseCRUDRepository<T, ID> {

    private final EntityManager em;


    public BaseCRUDRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
        super(entityInformation, em);
        this.em = em;
    }

    public <S extends T> S save(S entity)
    {
        return super.save(entity);
    }

    @Transactional
    public void delete(ID id) {
        System.out.println("ENTERING CUSTOM DELETE METHODDDDD " + id);
        super.delete(id);
    }

    @Transactional
    public void delete(T entity) {
        super.delete(entity);
    }


    public T saveWithoutFlush(T entity)
    {
        return super.save(entity);
    }

    public List<T> saveWithoutFlush(Iterable<? extends T> entities)
    {
        List<T> result = new ArrayList<T>();
        if (entities == null) {
            return result;
        }

        for (T entity : entities) {
            result.add(saveWithoutFlush(entity));
        }
        return result;
    }


}
