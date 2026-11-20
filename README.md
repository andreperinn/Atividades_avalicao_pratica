# Atividades — Avaliação Prática (Prova 02)

Soluções das atividades práticas da Prova 02 da disciplina de **Teste e Qualidade de Software**.

| Nome | RA | Turma | GitHub |
| --- | --- | --- | --- |
| André Perin Geraldo | 24017529-2 | ESOFT6SA | [@andreperinn](https://github.com/andreperinn) |

## Atividades

| Semana | Atividade | Pasta | Resumo |
| --- | --- | --- | --- |
| 10 | Implementar TDD nos quatro projetos disponíveis até a implementação e cobertura total | [`semana10_tdd`](semana10_tdd) | Bubble Sort, Conta Bancária, Estoque e Carrinho de Compras implementados com ciclos RED → GREEN → REFACTOR; 40 testes e **100% de cobertura** (instruções, desvios, linhas e métodos) verificada pelo JaCoCo |
| 11 | Implementar teste de integração no projeto Spring Boot | [`semana11_integracao`](semana11_integracao) | CT01 a CT05 (service + repository + H2 e HTTP com MockMvc), sem mocks; README com evidências, isolamento e respostas da discussão |
| 14 | Executar o teste de usuário para o problema proposto (Mercado Livre) | [`semana14_teste_usuario`](semana14_teste_usuario) | Plano do teste, roteiro do avaliador, questionário SUS e planilha de observação com cálculo automático das métricas e dos critérios de sucesso |

Cada pasta tem o seu próprio `README.md` com os detalhes da atividade.

## Como executar os testes

Requisitos: Java 17 ou superior e Maven.

```bash
mvn verify
```

Executado nesta pasta, o comando roda as atividades das Semanas 10 e 11:

- **Semana 10:** os testes dos quatro projetos e a verificação de cobertura total (o build falha se a cobertura ficar abaixo de 100%);
- **Semana 11:** os testes de integração com Spring Boot e banco H2 em memória.

Cada atividade também pode ser executada separadamente dentro da sua pasta (`cd semana10_tdd` e depois `mvn verify`, ou `cd semana11_integracao` e depois `mvn test`).

A Semana 14 não tem código: é um teste de usabilidade com usuários, documentado em [`semana14_teste_usuario`](semana14_teste_usuario).

## Histórico de commits

O histórico registra o trabalho em etapas. Na Semana 10, cada ciclo de TDD aparece como commits separados marcados com `(RED)`, `(GREEN)` e `(REFACTOR)`. Por exemplo:

```text
Carrinho R3: teste de soma de vários produtos (RED)
Carrinho R3: acumula os preços dos produtos (GREEN)
```
