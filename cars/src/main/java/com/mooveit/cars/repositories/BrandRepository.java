package com.mooveit.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Long>{

}