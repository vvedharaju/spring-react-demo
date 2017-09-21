package com.staybingo.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseCRUDRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
