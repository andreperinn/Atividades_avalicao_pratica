# Prova 02 — Semana 11: Testes de integração com Spring Boot

Testes de integração do projeto-base `exercicios_integracao_springboot`, com **Spring Boot 3, Spring Data JPA, banco H2 em memória, JUnit 5 e MockMvc**, sem mocks para `ProdutoService` ou `ProdutoRepository`. O enunciado original da lista está em [`ENUNCIADO.md`](ENUNCIADO.md).

| Nome | RA | Turma | GitHub |
| --- | --- | --- | --- |
| André Perin Geraldo | 24017529-2 | ESOFT6SA | [@andreperinn](https://github.com/andreperinn) |

---

## Como executar

Requisitos: Java 17 ou superior e Maven.

```bash
mvn test
```

Resultado:

```text
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 -- in br.edu.exemplo.ProdutoControllerIntegrationTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 -- in br.edu.exemplo.ProdutoServiceIntegrationTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## Casos de teste implementados

### Exercício 1 — Service + Repository + H2 (`ProdutoServiceIntegrationTest`)

| Caso | Método | O que o teste faz | Resultado |
| --- | --- | --- | --- |
| CT01 — Cadastro válido | `deveCadastrarERecuperarProduto` | Cadastra `Teclado` por `150.0` pelo service, confirma que recebeu ID, grava no H2, limpa o cache do JPA e busca com `repository.findById()` | Passou: nome `Teclado` e preço `150.0` lidos do banco |
| CT02 — Nome inválido | `naoDevePersistirProdutoComNomeEmBranco` | Conta os registros, tenta cadastrar nome em branco (`"   "`) com preço `80.0` | Passou: `IllegalArgumentException` com a mensagem `Nome obrigatório`, e a contagem não mudou |
| CT03 — Atualização (desafio) | `deveAtualizarPrecoPersistido` | Cadastra `Mouse` por `80.0`, atualiza para `95.0` com `atualizarPreco()` e busca de novo no banco | Passou: o preço lido do banco é `95.0` |

### Exercício 2 — HTTP com MockMvc (`ProdutoControllerIntegrationTest`)

| Caso | Método | Requisição | Resultado |
| --- | --- | --- | --- |
| CT04 — Cadastro via API | `deveCadastrarProdutoPelaApi` | `POST /produtos` com `{"nome":"Mouse","preco":80.0}` | Passou: HTTP `200`, JSON com `id` numérico, `nome` = `Mouse` e `preco` = `80.0` |
| CT05 — Consulta via API | `deveBuscarProdutoPelaApi` | `POST /produtos` com `Teclado` por `150.0`; o ID é extraído do JSON de resposta com `ObjectMapper`/`JsonNode`; depois `GET /produtos/{id}` | Passou: HTTP `200` e o JSON da consulta tem o mesmo `id`, `nome` e `preco` do cadastro |

---

## Evidências

### 1. As consultas vão de fato ao banco H2

Dentro de uma transação, o JPA guarda as entidades em memória (cache de primeiro nível ou *persistence context*). Sem cuidado, um `findById()` logo depois do cadastro devolve o próprio objeto em memória, sem consultar o banco. Por isso os testes chamam `entityManager.flush()` (grava no H2 o que está pendente) e `entityManager.clear()` (esvazia o cache) antes de consultar.

SQL executado pelo CT03, com `-Dspring.jpa.show-sql=true`:

```text
Hibernate: insert into produto (nome,preco,id) values (?,?,default)
Hibernate: select p1_0.id,p1_0.nome,p1_0.preco from produto p1_0 where p1_0.id=?
Hibernate: update produto set nome=?,preco=? where id=?
Hibernate: select p1_0.id,p1_0.nome,p1_0.preco from produto p1_0 where p1_0.id=?
```

O último `select` é a consulta do teste: o preço `95.0` foi lido do banco, depois do `update`.

### 2. Os testes detectam defeitos reais

Para confirmar que os testes não passam "por acaso", a aplicação foi alterada de propósito, um defeito por vez, numa cópia do projeto. Todos os defeitos foram detectados:

| Defeito introduzido | Detectado? |
| --- | --- |
| `cadastrar()` não salva no repositório | Sim |
| `cadastrar()` não valida o nome | Sim (CT02) |
| `atualizarPreco()` não altera o preço | Sim (CT03) |
| Campo `preco` não é gravado na tabela (`@Transient`) | Sim |
| `GET /produtos/{id}` busca outro ID | Sim (CT05) |
| `POST /produtos` ignora o preço enviado | Sim |
| Rota do `POST` alterada | Sim (CT04 e CT05) |

Com o defeito do `@Transient` e **sem** o `flush`/`clear`, o CT01 **passava**: o objeto em memória ainda tinha o preço, mas o banco não. Esse falso positivo é o motivo da sincronização com o banco antes de cada consulta.

---

## Isolamento dos testes

- **Banco em memória:** o H2 roda dentro da JVM do teste (`jdbc:h2:mem:produtos`) e o esquema é criado e apagado automaticamente (`ddl-auto=create-drop`). Não depende de nenhum banco externo.
- **`@Transactional` nas classes de teste:** cada método de teste roda dentro de uma transação que o Spring **desfaz (rollback)** ao terminar. Os produtos cadastrados por um teste não aparecem no próximo, e a ordem de execução não importa. Por isso o CT02 compara a contagem antes e depois, em vez de esperar um número fixo.
- **Sem mocks:** `ProdutoService` e `ProdutoRepository` são os beans reais do Spring (`@Autowired`), como pede a lista. Assim o teste verifica a integração entre as camadas, e não cada classe isolada.
- **Contexto reaproveitado:** as duas classes usam a mesma configuração, então o Spring sobe o contexto uma vez e o reaproveita, deixando a suíte rápida.

---

## Respostas às perguntas de discussão

**Exercício 1 — Por que a consulta com `repository.findById()` fornece uma evidência diferente de verificar apenas o objeto retornado pelo serviço?**
O objeto retornado por `service.cadastrar()` só prova que o método devolveu algo com os dados certos. Ele poderia ter sido montado em memória sem nunca ser salvo. Buscar pelo repositório verifica que o registro **foi persistido** e pode ser recuperado pelo ID, ou seja, que service, repository, JPA e banco estão integrados. Para essa evidência ser verdadeira, a consulta precisa ir ao banco, por isso o `flush()`/`clear()`: sem eles, o `findById()` devolve o mesmo objeto do cache e o teste daria falso positivo (ver o defeito `@Transient` acima).

**Exercício 1 — O que `@Transactional` faz ao término de cada teste?**
Em classes de teste, o Spring abre uma transação antes de cada método e faz **rollback** ao final, mesmo quando o teste passa. Tudo o que foi inserido ou alterado é desfeito, e cada teste começa com o banco no mesmo estado, sem interferir nos outros.

**Exercício 2 — Quais componentes são efetivamente exercitados?**
A camada web do Spring MVC (`DispatcherServlet`, roteamento de `/produtos`, conversão do JSON da requisição em `ProdutoRequest` e do `Produto` de resposta em JSON pelo Jackson), o `ProdutoController`, o `ProdutoService` com suas validações, o `ProdutoRepository` (Spring Data JPA/Hibernate) e o banco H2.

**Exercício 2 — Por que o MockMvc não precisa iniciar um servidor HTTP real?**
O MockMvc chama o `DispatcherServlet` do Spring diretamente, com objetos de requisição e resposta simulados (`MockHttpServletRequest` e `MockHttpServletResponse`), dentro da mesma JVM e da mesma thread do teste. Não abre porta nem passa pela rede, mas executa todo o processamento do Spring MVC (rotas, conversão de JSON, controller). Por rodar na mesma thread, a requisição também participa da transação do teste e é desfeita no rollback.

**Exercício 2 — Qual é a diferença entre esse teste e um teste unitário do controller com dependências simuladas?**
Num teste unitário (por exemplo, `@WebMvcTest` com o `ProdutoService` simulado por `@MockBean`), só o controller é real. O service devolve respostas programadas e nada chega ao banco, então o teste verifica o controller isolado. O teste de integração usa os componentes reais de todas as camadas e verifica se elas funcionam juntas. Ele detecta, por exemplo, um preço que não é gravado na tabela ou um `GET` que busca o registro errado, problemas que um teste com mocks não veria.
