package com.carsharingapp.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "logging.level.org.springframework.web=DEBUG")
@AutoConfigureMockMvc
public class DriverControllerTest {

    @Autowired
    private MockMvc mvc;


    @Sql("/driver.sql")
    @Test
    public void testFindAll() throws Exception {
        // TODO 0 list all drivers.

        mvc.perform(MockMvcRequestBuilders.get("/drivers/")
                                            .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                                        .string("[{" +
                                                "\"id\":1," +
                                                "\"firstName\":\"Cosmin\"," +
                                                "\"lastName\":\"Z\"," +
                                                "\"cars\":" +
                                                "[{\"id\":1,\"number\":\"IL11ABC\",\"seats\":2}]" +
                                                "}]"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSaveDriver() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/drivers/")
                .content("{" +
                        "\"firstName\":\"Marcela\"," +
                        "\"lastName\":\"Popescu\"" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{" +
                                "\"id\":1," +
                                "\"firstName\":\"Marcela\"," +
                                "\"lastName\":\"Popescu\"," +
                                "\"cars\":null" +
                                "}"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testFindCarsByDriver() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/drivers/1/cars")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("[]"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Sql("/driver-update.sql")
    @Test
    public void testSaveCarForADriver() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/drivers/1/cars/")
                .content("{\"carList\":[{" +
                        "\"number\":\"IL11ABC\"," +
                        "\"seats\":2" +
                        "}]}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{" +
                                "\"id\":1," +
                                "\"number\":\"IL11ABC\"," +
                                "\"seats\":2" +
                                "}]"))
                .andDo(MockMvcResultHandlers.print());

    }

}
