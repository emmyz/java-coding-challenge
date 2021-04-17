package com.mooveit.cars.repositories;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model,Long>{

}