package br.edu.exemplo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
@SpringBootTest @AutoConfigureMockMvc @Transactional
class ProdutoControllerIntegrationTest {
 @Autowired MockMvc mockMvc;
 @Autowired ObjectMapper objectMapper;
 @Autowired EntityManager entityManager;

 // CT04 — Cadastro via API
 @Test void deveCadastrarProdutoPelaApi() throws Exception {
  mockMvc.perform(post("/produtos")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"nome\":\"Mouse\",\"preco\":80.0}"))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id").isNumber())
      .andExpect(jsonPath("$.nome").value("Mouse"))
      .andExpect(jsonPath("$.preco").value(80.0));
 }

 // CT05 — Consulta via API
 @Test void deveBuscarProdutoPelaApi() throws Exception {
  MvcResult respostaDoCadastro = mockMvc.perform(post("/produtos")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"nome\":\"Teclado\",\"preco\":150.0}"))
      .andExpect(status().isOk())
      .andReturn();

  JsonNode produtoCadastrado = objectMapper.readTree(respostaDoCadastro.getResponse().getContentAsString());
  long id = produtoCadastrado.get("id").asLong();

  // grava no H2 e limpa o cache do JPA: o GET precisa buscar o produto no banco
  entityManager.flush();
  entityManager.clear();

  mockMvc.perform(get("/produtos/{id}", id))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(id))
      .andExpect(jsonPath("$.nome").value("Teclado"))
      .andExpect(jsonPath("$.preco").value(150.0));
 }
}
