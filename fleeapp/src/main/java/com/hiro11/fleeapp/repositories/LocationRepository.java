package com.hiro11.fleeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiro11.fleeapp.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
