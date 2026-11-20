# Carrinho de Compras — TDD

Projeto Maven para prática de TDD com Java 17 e JUnit 5.

## Executar os testes

```bash
mvn test
```

## Atividade

Leia `REQUISITOS.md` e implemente os requisitos sequencialmente.

Os testes não são fornecidos prontos: o objetivo desta prática é que cada
requisito seja convertido em um teste antes de sua implementação.

---

## Desenvolvimento com TDD

Cada requisito foi convertido em teste **antes** da implementação. No histórico de commits, cada requisito tem um commit `(RED)` com o teste falhando e um commit `(GREEN)` com a implementação.

| Requisito | Teste(s) em `CarrinhoTest` | RED (antes) | GREEN (implementação mínima) |
| --- | --- | --- | --- |
| R1 — Carrinho vazio | `carrinhoVazioDeveTerTotalZero` | Não compila: `getTotal()` não existe | `getTotal()` retorna 0 |
| R2 — Adicionar um produto | `deveAdicionarUmProduto` | Não compila: `adicionarProduto()` não existe | Guarda o preço do produto adicionado |
| R3 — Vários produtos | `deveSomarOsPrecosDeVariosProdutos` | `expected: <150.0> but was: <50.0>` (o segundo produto sobrescrevia o primeiro) | Acumula os preços |
| R4 — Remover produto | `deveRemoverProdutoDoCarrinho`, `removerProdutoQueNaoEstaNoCarrinhoNaoDeveAlterarOTotal`, `deveRemoverApenasUmaUnidadeQuandoHaProdutosRepetidos` | Não compila: `removerProduto()` não existe | Produtos guardados em lista; remove a primeira ocorrência pelo nome |
| R5 — Preço inválido | `naoDeveAdicionarProdutoComPrecoNegativo`, `deveAceitarProdutoComPrecoZero` | `Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown` | Preço negativo lança `IllegalArgumentException` e o carrinho não muda |
| R6 — Desconto | `compraDe600DeveTerDescontoDe10PorCento`, `deveAplicarDescontoSomenteAPartirDe500` (R$ 499,99, R$ 500,00 e R$ 500,01) | Não compila: `getSubtotal()` não existe | `getSubtotal()`, `getDesconto()` e `getTotal()` com 10% de desconto a partir de R$ 500,00 |
| REFACTOR | — | — | Constantes `VALOR_MINIMO_PARA_DESCONTO` e `PERCENTUAL_DE_DESCONTO`; soma com `stream()` |

**Decisão do requisito 5:** o sistema **lança exceção** (`IllegalArgumentException`) em vez de ignorar a operação, para que quem chama o método saiba que o dado é inválido. O carrinho continua como estava e preço zero é aceito (por exemplo, um brinde).

**Fronteiras do desconto:**

| Subtotal | Desconto | Total |
| --- | --- | --- |
| R$ 499,99 | R$ 0,00 | R$ 499,99 |
| R$ 500,00 | R$ 50,00 | R$ 450,00 |
| R$ 500,01 | R$ 50,001 | R$ 450,009 |
| R$ 600,00 | R$ 60,00 | R$ 540,00 |

**Cobertura (JaCoCo):** 100% de instruções (90/90), desvios (8/8), linhas (25/25) e métodos (9/9), contando `Carrinho` e `Produto`.
