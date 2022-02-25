package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.LandLordAssistantApplication;
import com.landlordassistant.application.repositories.RenterRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = LandLordAssistantApplication.class)
@AutoConfigureWebMvc
@TestPropertySource(
        locations = "classpath:application.properties")
@WebMvcTest
public class RestRenterControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RenterRepository renterRepository;


}
