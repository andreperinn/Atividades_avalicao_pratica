# Bubble Sort — TDD

Projeto Maven com Java 17 e JUnit 5.

A implementação do Bubble Sort foi propositalmente omitida.

## Executar

```bash
mvn test
```

Consulte `REQUISITOS.md` para a descrição da atividade.

---

## Desenvolvimento com TDD

Os testes fornecidos em `BubbleSortTest` não foram alterados. Os casos extras estão em `BubbleSortCasosAdicionaisTest`.

| Ciclo | Teste | RED (antes) | GREEN (depois) |
| --- | --- | --- | --- |
| 1 | Testes fornecidos (requisitos 1, 2 e 3) | 3 testes, 2 falhas: `array contents differ at index [0], expected: <1> but was: <5>` | `ordenar()` implementado com o Bubble Sort clássico: 3 testes passando |
| 2 | Bordas: ordem decrescente, negativos e zero, vetor vazio e vetor com um elemento | Passaram de primeira (confirmam o comportamento) | 7 testes passando |
| 3 | REFACTOR | — | Cada passada ignora o fim já ordenado, o laço para quando não há trocas e a troca virou o método `trocar()`: 7 testes passando |
| 4 | `naoDeveAceitarVetorNulo` | `Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown` | Construtor recusa vetor nulo: 8 testes passando |

**Cobertura (JaCoCo):** 100% de instruções (84/84), desvios (10/10), linhas (19/19) e métodos (4/4).
