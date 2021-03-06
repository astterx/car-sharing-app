package com.carsharingapp.repository;

import com.carsharingapp.domain.Ride;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends CrudRepository<Ride, Long> {

}
