package com.mooveit.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Submodel;

@Repository
public interface SubmodelRepository extends CrudRepository<Submodel,Long>{

}