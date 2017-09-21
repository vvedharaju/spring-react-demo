package com.staybingo.common.repositories;

import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.provider.QueryExtractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

/**
 *
 * The purpose of this class is to override the default behaviour of the spring JpaRepositoryFactory class.
 * It will produce a GenericRepositoryImpl object instead of SimpleJpaRepository.
 *
 */
public  class DefaultRepositoryFactory extends JpaRepositoryFactory {

    private final EntityManager entityManager;
    private final QueryExtractor extractor;


    public DefaultRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
//        Assert.notNull(entityManager);
        this.entityManager = entityManager;
        this.extractor = PersistenceProvider.fromEntityManager(entityManager);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T, ID extends Serializable> JpaRepository<?, ?> getTargetRepository(
            RepositoryMetadata metadata, EntityManager entityManager) {

        Class<?> repositoryInterface = metadata.getRepositoryInterface();

        JpaEntityInformation<?, Serializable> entityInformation =
                getEntityInformation(metadata.getDomainType());

        if (isQueryDslExecutor(repositoryInterface)) {
            return new QueryDslJpaRepository(entityInformation, entityManager);
        } else {
            return new BaseCRUDRepositoryImpl(entityInformation, entityManager, repositoryInterface); //custom implementation
        }
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

        if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
            return QueryDslJpaRepository.class;
        } else {
            return BaseCRUDRepositoryImpl.class;
        }
    }

    /**
     * Returns whether the given repository interface requires a QueryDsl
     * specific implementation to be chosen.
     *
     * @param repositoryInterface
     * @return
     */
    private boolean isQueryDslExecutor(Class<?> repositoryInterface) {

        return QUERY_DSL_PRESENT
                && QueryDslPredicateExecutor.class
                .isAssignableFrom(repositoryInterface);
    }
}