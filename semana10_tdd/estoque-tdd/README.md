# Estoque — Exemplo de TDD

Projeto Maven com Java 17 e JUnit 5 para demonstração de TDD.

## Executar

```bash
mvn test
```

## Casos de teste

1. Produto inicia com estoque zero.
2. Adicionar unidades ao estoque.
3. Acumular várias entradas.
4. Retirar unidades do estoque.
5. Não permitir retirada maior que o estoque disponível.
6. Não permitir entrada com quantidade negativa.

A proposta didática é construir a implementação incrementalmente, executando
os testes durante os ciclos RED → GREEN → REFACTOR.

---

## Desenvolvimento com TDD

Os testes fornecidos em `ProdutoTest` não foram alterados. Os casos extras estão em `ProdutoCasosAdicionaisTest`. Operações inválidas são **ignoradas** (o estoque não muda), como pedem os requisitos 5 e 6.

| Ciclo | Requisito | RED (antes) | GREEN (depois) |
| --- | --- | --- | --- |
| — | R1 — Estoque inicial zero | Já passava no projeto-base | — |
| 1 | R2 e R3 — Adicionar e acumular | 6 testes, 4 falhas: `expected: <10> but was: <0>` | `adicionarEstoque()` soma; o teste do R6, que passava por acaso, ficou RED: `expected: <0> but was: <-10>` |
| 2 | R6 — Não aceitar entrada negativa ou zero | (falha do ciclo 1) | Entrada inválida ignorada |
| 3 | R4 — Retirar | `deveRetirarProdutoDoEstoque: expected: <7> but was: <10>` | `retirarEstoque()` subtrai; o teste do R5 ficou RED: `expected: <10> but was: <-5>` |
| 4 | R5 — Não deixar o estoque negativo | (falha do ciclo 3) | Retirada maior que o estoque ignorada: 6 testes passando, **mas a cobertura ficou em 92% das linhas e 80% dos métodos** (`getNome()` sem teste) |
| 5 | Nome do produto, entrada zero, retirar todo o estoque, retirada negativa ou zero | `naoDeveRetirarQuantidadeNegativa: expected: <10> but was: <15>` | Retirada inválida ignorada: 11 testes passando e cobertura total |
| 6 | REFACTOR | — | Validação extraída para `quantidadePositiva()`: 11 testes passando |

**Cobertura (JaCoCo):** 100% de instruções (49/49), desvios (8/8), linhas (15/15) e métodos (6/6).
