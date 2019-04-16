package com.srmasset.demo.app;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.srmasset.demo.api.Client;
import com.srmasset.demo.api.Risk;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@TestPropertySource(locations = "classpath:application-IntegrationTest.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class ClientControllerIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void shouldCreateAClientRiskA() throws Exception {

        Client client = new Client("Patrick", 1000d, Risk.A, null);
        String json = mapper.writeValueAsString(client);
        mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Patrick")))
                .andExpect(jsonPath("$.risk", is("A")))
                .andExpect(jsonPath("$.interestRate", is(0)));
    }

    @Test
    public void shouldCreateAClientRiskB() throws Exception {

        Client client = new Client("Patrick", 1000d, Risk.B, null);
        String json = mapper.writeValueAsString(client);
        mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Patrick")))
                .andExpect(jsonPath("$.risk", is("B")))
                .andExpect(jsonPath("$.interestRate", is(10)));
    }

    @Test
    public void shouldCreateAClientRiskC() throws Exception {

        Client client = new Client("Patrick", 1000d, Risk.C, null);
        String json = mapper.writeValueAsString(client);
        mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Patrick")))
                .andExpect(jsonPath("$.risk", is("C")))
                .andExpect(jsonPath("$.interestRate", is(20)));
    }


    @Test
    public void shouldNotCreateAClient() throws Exception {

        Client client = new Client("Patrick", 1000d, null, 2);
        String json = mapper.writeValueAsString(client);
        mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.message", is("Invalid request")));

    }

    @Test
    public void shouldGetAllClients() throws Exception {
        mockMvc.perform(get("/client"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Chris")));
    }
}