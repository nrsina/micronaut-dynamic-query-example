package com.snourian.example.dynquery.repository;

import com.snourian.example.dynquery.domain.Technology;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, String> {
}
