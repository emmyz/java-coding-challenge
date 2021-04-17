package com.mooveit.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Engine;

@Repository
public interface EngineRepository extends CrudRepository<Engine,Long>{

}