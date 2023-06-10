package fr.esgi.plage;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.plage.business.Client;
import fr.esgi.plage.dto.ClientDto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class ClientRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(2)
    void testGetClients() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clients");

        mockMvc.perform(requestBuilder)
          .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
          .andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("titi"));
    }

    @Test
    @Order(1)
    void testPostClient() throws Exception {
        ClientDto clientDto = new ClientDto();
        String email = "toto.tata@gmail.com";
        String nom = "toto";
        String prenom = "tata";
        String mdp = "titi1234";

        clientDto.setEmail(email);
        clientDto.setNom(nom);
        clientDto.setPrenom(prenom);
        clientDto.setMdp(mdp);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/client")
          .content(objectMapper.writeValueAsString(clientDto))
          .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
          .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(nom))
          .andExpect(MockMvcResultMatchers.jsonPath("$.prenom").value(prenom))
          .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email))
          .andExpect(MockMvcResultMatchers.jsonPath("$.mdp").value(mdp))
          .andExpect(status().isCreated());;
    }

    @Test
    @Order(3)
    void testPostClientShouldReturnConflict() throws Exception {
        ClientDto clientDto = new ClientDto();
        String email = "toto.tata@gmail.com";
        String nom = "titi";
        String prenom = "tata";
        String mdp = "titi1234";
        Long id = 1L;


        clientDto.setEmail(email);
        clientDto.setNom(nom);
        clientDto.setPrenom(prenom);
        clientDto.setMdp(mdp);
        clientDto.setId(id);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/client")
          .content(objectMapper.writeValueAsString(clientDto))
          .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
          .andExpect(status().isConflict())
          .andExpect(MockMvcResultMatchers.content().string("Ce client est déjà présent"))
          .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testGetClient() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clients/1");

        mockMvc.perform(requestBuilder)
          .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("titi"))
          .andExpect(status().is2xxSuccessful())
          .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteClient() throws  Exception{
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/client/2");

        mockMvc.perform(requestBuilder)
          .andExpect(MockMvcResultMatchers.jsonPath("$").value(true))
          .andExpect(status().is2xxSuccessful())
          .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testPutClient() throws Exception {
        ClientDto clientDto = new ClientDto();
        String email = "toto.tata@gmail.com";
        String nom = "titi";
        String prenom = "tata";
        String mdp = "Toto1234";
        Long id = 1L;

        clientDto.setEmail(email);
        clientDto.setNom(nom);
        clientDto.setPrenom(prenom);
        clientDto.setMdp(mdp);
        clientDto.setId(id);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/client")
          .content(objectMapper.writeValueAsString(clientDto))
          .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
          .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(nom))
          .andExpect(MockMvcResultMatchers.jsonPath("$.prenom").value(prenom))
          .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email))
          .andExpect(MockMvcResultMatchers.jsonPath("$.mdp").value(mdp))
          .andExpect(status().isOk());
    }

    @Test
    void testPutClientInError() throws Exception {
        ClientDto clientDto = new ClientDto();
        String email = "toto.tata@gmail.com";
        String nom = "titi";
        String prenom = "tata";
        String mdp = "Toto1234";

        clientDto.setEmail(email);
        clientDto.setNom(nom);
        clientDto.setPrenom(prenom);
        clientDto.setMdp(mdp);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/client")
          .content(objectMapper.writeValueAsString(clientDto))
          .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
          .andExpect(status().isConflict())
          .andExpect(MockMvcResultMatchers.content().string("Il manque l'id du client"))
          .andDo(MockMvcResultHandlers.print());
    }
}

