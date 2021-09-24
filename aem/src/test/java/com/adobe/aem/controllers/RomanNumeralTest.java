package com.adobe.aem.controllers;

import com.adobe.aem.service.RomanConvertorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= RomanNumeral.class)
public class RomanNumeralTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RomanConvertorService romanConvertorService;

    @Test
    public void integerToRomanTestLessThanOne() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/romannumeral?integer="+0).
                accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{integer} must be any integer value in the range 1-255";
        assertEquals(expected, result.getResolvedException().getMessage());
    }

    @Test
    public void integerToRomanTestWithinRange() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/romannumeral?integer="+1).
                accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void integerToRomanTestParallel() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/romannumeral?min="+1+"&max="+3999).
                accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void integerToRomanTestParallelException() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/romannumeral?min="+0+"&max="+4000).
                accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{integer} must be an integer value for both the min and max parameters. " +
                "Both min and max must be provided. Min must be less than max. Both must be in the " +
                "supported range of 1 - 3999";
        assertEquals(expected, result.getResolvedException().getMessage());
    }

}
