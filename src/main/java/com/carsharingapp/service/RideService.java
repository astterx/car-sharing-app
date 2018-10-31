package com.carsharingapp.service;

import com.carsharingapp.domain.Ride;
import com.carsharingapp.repository.RideRepository;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }


    public Ride save(Ride ride) {

        return rideRepository.save(ride);
    }
}
