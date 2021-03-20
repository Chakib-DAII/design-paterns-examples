package com.example.design.patterns.operational.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public interface SampleRepository extends CrudRepository<SampleEntity, Long> {
    SampleEntity findByName(String name);
}
