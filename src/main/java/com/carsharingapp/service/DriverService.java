package com.carsharingapp.service;

import com.carsharingapp.domain.Car;
import com.carsharingapp.domain.Driver;
import com.carsharingapp.exception.DriverNotFoundException;
import com.carsharingapp.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }


    public List<Driver> findAll() {
        return repository.findAll();
    }

    public Driver findById(Long id) {
        return repository.findById(id).orElseThrow(DriverNotFoundException::new);
    }

    public Driver save(Driver driver) {
        return repository.save(driver);
    }

    public List<Car> saveCars(Long id, List<Car> cars) {
        Driver driver = repository.findById(id).orElseThrow(DriverNotFoundException::new);
        cars.forEach(car -> driver.getCars().add(car));
        repository.save(driver);
        return driver.getCars();
    }
}
