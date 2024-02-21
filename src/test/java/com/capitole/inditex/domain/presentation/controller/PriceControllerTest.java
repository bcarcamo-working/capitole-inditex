package com.capitole.inditex.domain.presentation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRequestAt10AM() throws Exception {
        performTest("2020-06-14T10:00:00");
    }

    @Test
    void testRequestAt4PM() throws Exception {
        performTest("2020-06-14T16:00:00");
    }

    @Test
    void testRequestAt9PM() throws Exception {
        performTest("2020-06-14T21:00:00");
    }

    @Test
    void testRequestNextDayAt10AM() throws Exception {
        performTest("2020-06-15T10:00:00");
    }

    @Test
    void testRequestNextDayAt9PM() throws Exception {
        performTest("2020-06-16T21:00:00");
    }

    private void performTest(String dateTime) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("dateTime", dateTime)
                .param("productId", "35455")
                .param("brandId", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
