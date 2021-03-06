package com.carsharingapp.repository;


import com.carsharingapp.domain.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Sql("/passenger.sql")
@DataJpaTest
public class PassengerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(PassengerRepositoryTest.class);
    @Autowired
    PassengerRepository repository;

    @Test
    public void test1() {
        repository.deleteById(1L);
    }

    @Test
    public void test2() {
        Passenger ana = repository.findById(1L)
                .orElseThrow(() -> new IllegalStateException("cant go on without Ana"));

        assertNotNull(ana);

    }

}
