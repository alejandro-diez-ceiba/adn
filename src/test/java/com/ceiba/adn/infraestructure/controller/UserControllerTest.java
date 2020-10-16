package com.ceiba.adn.infraestructure.controller;

import com.ceiba.adn.application.command.UserCommand;
import com.ceiba.adn.databuilder.UserTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@Sql(scripts = {"classpath:clean.sql", "classpath:test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getById() throws Exception {
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/user/{id}", "1")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.fullName").value("Pepito Cardenas")
                );
    }

    @Test
    public void getAll() throws Exception {
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/user")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.length()").value(1)
                );
    }

    @Test
    public void create() throws Exception {
        UserCommand userCommand = new UserTestDataBuilder().buildUserCommand();
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/user")
                                .content(objectMapper.writeValueAsString(userCommand))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk()
                );
    }

    @Test
    public void delete() throws Exception {
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .delete("/user/{id}", "1")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
