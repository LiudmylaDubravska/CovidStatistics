package com.liudmyla.covid.repository;

import com.liudmyla.covid.entity.CountryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
    List<CountryEntity> findByCode(String code);

    @Query("SELECT c FROM CountryEntity c WHERE c.code = :code")
    List<CountryEntity> findActiveElements(String code);
}