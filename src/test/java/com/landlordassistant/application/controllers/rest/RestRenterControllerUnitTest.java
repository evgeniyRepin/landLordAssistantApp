package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.embedded.Gender;
import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.services.RenterService;
import com.landlordassistant.application.services.RenterServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestRenterController.class)
public class RestRenterControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RenterServiceImplementation renterService;

    @Test
    public void givenRenters_whenGetAllRenters_thenReturnJsonArray()
            throws Exception {

        Renter spongeBob =
                new Renter("Sponge", "Bob", "SquarePants",
                        Gender.MALE, LocalDate.of(2021, 1, 1));

        List<Renter> allRenters = Arrays.asList(spongeBob);

        given(renterService.getAllRenters()).willReturn(allRenters);

        mvc.perform(get("/api/renters")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(spongeBob.getName())));
    }
}
