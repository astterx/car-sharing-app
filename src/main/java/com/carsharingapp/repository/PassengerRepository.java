package com.carsharingapp.repository;

import com.ing.switchtojava.carpoolingapi.domain.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
}
