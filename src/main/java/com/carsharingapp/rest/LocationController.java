package com.carsharingapp.rest;

import com.carsharingapp.domain.Location;
import com.carsharingapp.exception.LocationNotFoundException;
import com.carsharingapp.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locations/")
public class LocationController {
    private static final Logger log = LoggerFactory.getLogger(LocationController.class);
    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Location> findAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Location findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(LocationNotFoundException::new);
    }

    @PutMapping
    public Location save(@Valid @RequestBody Location location) {
        return repository.save(location);
    }
}
