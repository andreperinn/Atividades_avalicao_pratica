# Prova 02 — Semana 10: TDD nos quatro projetos

Implementação, com **TDD (Test-Driven Development)**, dos quatro projetos disponibilizados na Semana 10 da disciplina de Teste e Qualidade de Software, até a implementação completa e a **cobertura total** de código.

| Nome | RA | Turma | GitHub |
| --- | --- | --- | --- |
| André Perin Geraldo | 24017529-2 | ESOFT6SA | [@andreperinn](https://github.com/andreperinn) |

---

## Projetos

| Projeto | O que foi implementado | Testes | Cobertura |
| --- | --- | --- | --- |
| [`bubblesort-tdd`](bubblesort-tdd) | `BubbleSort.ordenar()` | 8 (3 fornecidos + 5 adicionais) | 100% |
| [`conta-bancaria-tdd-maven`](conta-bancaria-tdd-maven) | `ContaBancaria.depositar()` e `sacar()` | 9 (4 fornecidos + 5 adicionais) | 100% |
| [`estoque-tdd`](estoque-tdd) | `Produto.adicionarEstoque()` e `retirarEstoque()` | 11 (6 fornecidos + 5 adicionais) | 100% |
| [`carrinho-compras-tdd`](carrinho-compras-tdd) | Classe `Carrinho` inteira, requisitos 1 a 6 | 12 (todos escritos antes da implementação) | 100% |

Cobertura medida pelo **JaCoCo** em instruções, desvios (branches), linhas e métodos. O README de cada projeto traz a tabela de ciclos de TDD daquele projeto, com a falha (RED) que cada teste mostrou antes da implementação.

---

## Como executar

Requisitos: Java 17 ou superior e Maven.

```bash
mvn verify
```

Executado nesta pasta, o comando roda os testes dos quatro projetos e verifica a cobertura. Também é possível executar dentro de cada projeto (`cd carrinho-compras-tdd` e depois `mvn verify`).

- `mvn test` executa apenas os testes.
- `mvn verify` executa os testes, gera o relatório de cobertura em `target/site/jacoco/index.html` e **falha se a cobertura de linhas, desvios ou métodos ficar abaixo de 100%** (regra configurada no `pom.xml` de cada projeto com o plugin `jacoco-maven-plugin`).

Resultado da execução:

```text
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0     (bubblesort-tdd)
[INFO] All coverage checks have been met.
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0     (conta-bancaria-tdd)
[INFO] All coverage checks have been met.
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0    (estoque-tdd)
[INFO] All coverage checks have been met.
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0    (carrinho-compras-tdd)
[INFO] All coverage checks have been met.
[INFO] BUILD SUCCESS
```

| Projeto | Instruções | Desvios | Linhas | Métodos |
| --- | --- | --- | --- | --- |
| bubblesort-tdd | 100% (84/84) | 100% (10/10) | 100% (19/19) | 100% (4/4) |
| conta-bancaria-tdd-maven | 100% (46/46) | 100% (8/8) | 100% (13/13) | 100% (5/5) |
| estoque-tdd | 100% (49/49) | 100% (8/8) | 100% (15/15) | 100% (6/6) |
| carrinho-compras-tdd | 100% (90/90) | 100% (8/8) | 100% (25/25) | 100% (9/9) |

---

## Como o TDD foi aplicado

Cada comportamento passou pelo ciclo:

```text
TESTE  →  RED (falha)  →  IMPLEMENTAÇÃO MÍNIMA  →  GREEN (passa)  →  REFACTOR
```

- **Histórico de commits como evidência:** cada etapa virou um commit, com `(RED)`, `(GREEN)` ou `(REFACTOR)` no título. Por exemplo, no carrinho, `Carrinho R3: teste de soma de vários produtos (RED)` vem antes de `Carrinho R3: acumula os preços dos produtos (GREEN)`.
- **Implementação mínima de verdade:** no carrinho, o requisito 2 foi resolvido apenas guardando o preço do produto adicionado. O teste do requisito 3 falhou (`expected: <150.0> but was: <50.0>`) e só então a soma foi implementada.
- **Testes que passavam "por acaso":** na conta bancária e no estoque, testes de regras de proteção (saque maior que o saldo, entrada negativa) passavam no projeto-base porque os métodos estavam vazios. Ao implementar o comportamento principal, eles ficaram RED, e a regra foi implementada em um ciclo próprio.
- **Cobertura guiando testes:** no estoque, todos os testes fornecidos passavam, mas o JaCoCo apontou 92% das linhas e 80% dos métodos cobertos, porque `getNome()` nunca era testado. Isso gerou o teste `produtoDeveGuardarONome`.
- **Testes fornecidos intactos:** `BubbleSortTest`, `ContaBancariaTest` e `ProdutoTest` não foram alterados, como pede a atividade. Os casos extras ficam em classes `...CasosAdicionaisTest` separadas.

### Decisões de comportamento

| Projeto | Situação | Decisão (definida por teste) |
| --- | --- | --- |
| Conta bancária | Depósito ou saque com valor negativo ou zero; saque maior que o saldo | A operação é ignorada e o saldo não muda (mesmo padrão do teste fornecido) |
| Estoque | Entrada negativa ou zero; retirada negativa, zero ou maior que o estoque | A operação é ignorada e o estoque não muda (requisitos 5 e 6) |
| Bubble Sort | Vetor nulo | O construtor lança `IllegalArgumentException` |
| Carrinho | Produto com preço negativo (requisito 5) | Lança `IllegalArgumentException` e o carrinho não muda; preço zero é aceito |
| Carrinho | Desconto (requisito 6) | 10% para subtotal **maior ou igual** a R$ 500,00, testado em R$ 499,99, R$ 500,00 e R$ 500,01 |

---

## Estrutura

```
.
├── pom.xml                       # agrupa os 4 projetos (mvn verify roda todos)
├── bubblesort-tdd/
├── conta-bancaria-tdd-maven/
├── estoque-tdd/
└── carrinho-compras-tdd/
```
