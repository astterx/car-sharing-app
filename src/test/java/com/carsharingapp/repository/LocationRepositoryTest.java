package com.carsharingapp.repository;


import com.carsharingapp.domain.Location;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepositoryTest {

    @Autowired
    LocationRepository repository;

    @Test
    public void test() {

        Location location = new Location();
        location.setLatitude(44.4513003);
        location.setLongitude(26.0415585);
        location.setAddress("aleea lacul morii nr. 4");
        location.setCity("Bucuresti");
        location.setZip("123-123");
        location.setState("B");
        Location dbLocation = repository.saveAndFlush(location);
        Assert.assertNotNull(dbLocation.getId());
    }

    @Test
    public void testFind() {

        Location location = new Location();
        location.setLatitude(44.4513003);
        location.setLongitude(26.0415585);
        location.setAddress("Crangasi");
        location.setCity("Bucuresti");
        location.setZip("123-123");
        location.setState("B");
        Location dbLocation = repository.save(location);

        Optional<Location> fromFind = repository.findById(dbLocation.getId());
        Assert.assertEquals(dbLocation.getId(), fromFind.get().getId());
    }
}
