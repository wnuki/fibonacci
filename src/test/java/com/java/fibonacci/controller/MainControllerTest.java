package com.java.fibonacci.controller;

import com.java.fibonacci.model.OperationModel;
import com.java.fibonacci.service.FastFibonacci;
import com.java.fibonacci.service.IterativeFibonacci;
import com.java.fibonacci.service.RecursiveFibonacci;
import com.java.fibonacci.service.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RecursiveFibonacci recursiveFibonacci;

    @MockBean
    IterativeFibonacci iterativeFibonacci;

    @MockBean
    FastFibonacci fastFibonacci;

    @MockBean
    Time time;

    @MockBean
    OperationModel operationModel;

    @Test
    public void statusTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void resultTest() throws Exception {
        mockMvc.perform(post("/").param("n", "1"))
                .andExpect(status().isOk());
    }

}