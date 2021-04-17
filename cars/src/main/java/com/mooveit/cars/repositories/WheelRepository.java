package com.mooveit.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Wheel;

@Repository
public interface WheelRepository extends CrudRepository<Wheel,Long>{

}