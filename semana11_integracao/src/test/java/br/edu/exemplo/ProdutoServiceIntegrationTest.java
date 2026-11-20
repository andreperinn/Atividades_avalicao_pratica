package br.edu.exemplo;
import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class ProdutoServiceIntegrationTest {
 @Autowired ProdutoService service;
 @Autowired ProdutoRepository repository;
 @Autowired EntityManager entityManager;

 // Grava as alterações pendentes no H2 e limpa o cache do JPA,
 // para que a próxima consulta faça um SELECT real no banco.
 private void sincronizarComOBanco(){
  entityManager.flush();
  entityManager.clear();
 }

 // CT01 — Cadastro válido
 @Test void deveCadastrarERecuperarProduto(){
  Produto cadastrado = service.cadastrar("Teclado", 150.0);
  assertNotNull(cadastrado.getId());

  sincronizarComOBanco();

  Produto doBanco = repository.findById(cadastrado.getId()).orElseThrow();
  assertEquals("Teclado", doBanco.getNome());
  assertEquals(150.0, doBanco.getPreco(), 0.001);
 }

 // CT02 — Nome inválido
 @Test void naoDevePersistirProdutoComNomeEmBranco(){
  long quantidadeAntes = repository.count();

  IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
          () -> service.cadastrar("   ", 80.0));

  assertEquals("Nome obrigatório", erro.getMessage());
  assertEquals(quantidadeAntes, repository.count());
 }

 // CT03 — Atualização (desafio)
 @Test void deveAtualizarPrecoPersistido(){
  Produto mouse = service.cadastrar("Mouse", 80.0);
  sincronizarComOBanco();

  service.atualizarPreco(mouse.getId(), 95.0);
  sincronizarComOBanco();

  Produto doBanco = repository.findById(mouse.getId()).orElseThrow();
  assertEquals("Mouse", doBanco.getNome());
  assertEquals(95.0, doBanco.getPreco(), 0.001);
 }
}
