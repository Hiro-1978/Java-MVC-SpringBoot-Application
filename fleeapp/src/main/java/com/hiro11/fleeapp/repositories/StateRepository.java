package com.hiro11.fleeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiro11.fleeapp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
