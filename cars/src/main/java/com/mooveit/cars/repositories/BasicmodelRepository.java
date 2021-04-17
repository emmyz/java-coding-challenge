package com.mooveit.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Basicmodel;
/*
* Queries:
* extends CrudRepository -> PagingAndSorting to save entities
* work with Basicmodel entity
 */
@Repository
public interface BasicmodelRepository extends CrudRepository<Basicmodel,Long>{

}