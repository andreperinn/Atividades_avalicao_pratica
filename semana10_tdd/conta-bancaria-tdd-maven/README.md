# Conta Bancária — TDD

Projeto Maven com Java 17 e JUnit 5.

## Executar
```bash
mvn test
```

## Prática
1. Execute os testes antes da implementação (RED).
2. Implemente o mínimo necessário.
3. Execute novamente até passar (GREEN).
4. Repita para o próximo comportamento.
5. Refatore mantendo os testes passando.

A classe `ContaBancaria` está propositalmente incompleta.

---

## Desenvolvimento com TDD

Os testes fornecidos em `ContaBancariaTest` não foram alterados. Os casos extras estão em `ContaBancariaCasosAdicionaisTest`. Operações inválidas são **ignoradas** (o saldo não muda), seguindo o padrão do teste fornecido `naoDevePermitirSaqueMaiorQueSaldo`.

| Ciclo | Comportamento | RED (antes) | GREEN (depois) |
| --- | --- | --- | --- |
| 1 | Depositar e acumular depósitos | 4 testes, 4 falhas: `expected: <100.0> but was: <0.0>` | `depositar()` soma ao saldo: testes de depósito passando |
| 2 | Sacar | `deveSacarValorDaConta: expected: <60.0> but was: <100.0>` | `sacar()` subtrai do saldo; o teste de saldo insuficiente, que antes passava por acaso, ficou RED: `expected: <100.0> but was: <-50.0>` |
| 3 | Não sacar mais que o saldo | (falha do ciclo 2) | Saque maior que o saldo é ignorado: 4 testes passando |
| 4 | Não depositar valor negativo ou zero | `naoDeveDepositarValorNegativo: expected: <100.0> but was: <50.0>` | Depósito inválido ignorado: 7 testes passando |
| 5 | Não sacar valor negativo ou zero | `naoDeveSacarValorNegativo: expected: <100.0> but was: <130.0>` | Saque inválido ignorado: 9 testes passando |
| 6 | REFACTOR | — | Validação extraída para `valorPositivo()`: 9 testes passando |

**Cobertura (JaCoCo):** 100% de instruções (46/46), desvios (8/8), linhas (13/13) e métodos (5/5).
