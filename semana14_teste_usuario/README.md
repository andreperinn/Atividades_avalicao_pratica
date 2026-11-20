# Prova 02 — Semana 14: Teste de Usuário Final

Teste de usabilidade com usuários finais no site do **Mercado Livre**, conforme o roteiro *Teste de Usuário Final* da disciplina de Teste e Qualidade de Software.

| Nome | RA | Turma | GitHub |
| --- | --- | --- | --- |
| André Perin Geraldo | 24017529-2 | ESOFT6SA | [@andreperinn](https://github.com/andreperinn) |

## Arquivos

| Arquivo | Conteúdo |
| --- | --- |
| [`roteiro_do_avaliador.md`](roteiro_do_avaliador.md) | Passo a passo da sessão: piloto, preparação, fala de abertura, tarefas, o que registrar e regras de ajuda |
| [`questionario_sus.md`](questionario_sus.md) | Questionário SUS (10 afirmações, escala de 1 a 5) e forma de cálculo |
| [`planilha_teste_usuario.xlsx`](planilha_teste_usuario.xlsx) | Planilha de observação (tempo, sucesso, ajuda e erros por tarefa), respostas do SUS e resumo calculado automaticamente |

---

## 1. Objetivo

Avaliar a **facilidade de uso, a eficiência e a clareza da interface** durante as etapas de **busca, comparação e simulação de compra** de um produto no site Mercado Livre, observando o comportamento do usuário final e aplicando conceitos de IHC e testes de usabilidade.

## 2. Cenário de uso

O participante está procurando **um fone de ouvido sem fio** para uso diário e quer comprar pelo Mercado Livre. O objetivo é **encontrar um modelo com boa avaliação**, comparar opções e **simular a compra até o carrinho**, sem finalizar o pagamento.

## 3. Tarefas

1. Acessar o site https://www.mercadolivre.com.br.
2. Pesquisar "fone de ouvido Bluetooth".
3. Usar os filtros para selecionar apenas produtos **com entrega Full** e ordenar pelos **melhores avaliados**.
4. Escolher um produto e acessar os detalhes.
5. Adicionar o item ao carrinho.
6. Simular o início da compra (sem concluir o pagamento).
7. Retornar à tela inicial.

## 4. Métricas e critérios de sucesso

| Métrica | Descrição | Critério de sucesso |
| --- | --- | --- |
| Tempo de execução | Tempo total para completar todas as tarefas | Tempo médio de até **4 minutos** |
| Taxa de sucesso | Quantos usuários concluíram o fluxo sem ajuda | — |
| Erros cometidos | Cliques incorretos, perda do caminho, confusão nos filtros | — |
| Adição ao carrinho | Usuários que conseguiram adicionar o produto ao carrinho | **90%** dos usuários |
| Satisfação (SUS) | Nota de 0 a 100 no questionário SUS | Referência: 68 (média da escala) |

## 5. Organização

| Papel | Descrição |
| --- | --- |
| Usuário final | Aluno que executa as tarefas como comprador |
| Avaliador | Colega que observa e registra tempo, erros e comentários |
| Instrutor | Professor que orienta e supervisiona o teste |

**Ferramentas:** navegador web em janela anônima, cronômetro, planilha de observação ([`planilha_teste_usuario.xlsx`](planilha_teste_usuario.xlsx)) e questionário SUS ([`questionario_sus.md`](questionario_sus.md)).

### Participantes

| Participante | Perfil | Data | Dispositivo | Avaliador |
| --- | --- | --- | --- | --- |
| P1 | 60 anos; usa o celular no dia a dia e compra online | 20/11/2026 | Celular da participante (acesso ao site pela busca do Google) | André Perin Geraldo |

## 6. Procedimento

A sessão seguiu o [`roteiro_do_avaliador.md`](roteiro_do_avaliador.md):

1. Leitura da fala de abertura e do cenário de uso.
2. Leitura das tarefas uma por vez, com o tempo de cada tarefa cronometrado pelo avaliador.
3. Registro de conclusão, necessidade de ajuda, erros e comentários durante a sessão.
4. Aplicação do questionário SUS ao final.
5. Transferência dos registros para a planilha ([`planilha_teste_usuario.xlsx`](planilha_teste_usuario.xlsx)), que calcula as métricas e os critérios de sucesso.

---

## 7. Resultados

Números calculados pela aba **Resumo** da planilha.

### Planilha de observação (P1)

| Tarefa | Tempo (s) | Concluiu | Precisou de ajuda | Erros | Observações |
| --- | --- | --- | --- | --- | --- |
| 1. Acessar o site | 32 | S | N | 0 | Foi pela busca do Google no celular, digitou "Mercado Livre" e abriu o site com facilidade. |
| 2. Pesquisar o produto | 20 | S | S | 0 | Teve dificuldade apenas para escrever "Bluetooth"; precisou de ajuda para digitar. |
| 3. Aplicar filtros | 98 | N | S | 1 | Não encontrou onde ficam os filtros e desistiu; o avaliador ajudou. |
| 4. Abrir detalhes | 37 | S | N | 0 | Abriu um produto e viu os detalhes com facilidade. |
| 5. Adicionar ao carrinho | 12 | S | N | 0 | Usou o produto já aberto na tarefa anterior e colocou no carrinho. |
| 6. Simular compra | 23 | S | N | 0 | Os dados estavam salvos na conta Google: apenas validou a verificação e o endereço foi preenchido automaticamente. |
| 7. Retornar à tela inicial | 12 | S | N | 0 | Voltou para a tela inicial com facilidade. |
| **Total** | **234 (3min54s)** | **6 de 7** | **2 tarefas** | **1** | |

### Critérios de sucesso

| Métrica | Resultado | Meta | Atingiu? |
| --- | --- | --- | --- |
| Usuários que adicionaram o produto ao carrinho | 100% (1 de 1) | 90% | Sim |
| Tempo médio para concluir o teste | 234 s (3,9 min) | até 4 min (240 s) | Sim |
| Taxa de sucesso (fluxo completo sem ajuda) | 0% (0 de 1): 5 de 7 tarefas sem ajuda | — | — |
| Média de erros por participante | 1 | — | — |
| Nota SUS | 92,5 | 68 (referência) | Sim, acima da média |

Respostas do SUS (Q1 a Q10): 4, 1, 5, 2, 5, 1, 5, 2, 5, 1.

### Tempo por tarefa

A tarefa 3 (filtros) consumiu **98 s, 42% do tempo total**, mais que o dobro de qualquer outra tarefa.

| Tarefa | Tempo (s) | Parcela do tempo total |
| --- | --- | --- |
| 1. Acessar o site | 32 | 14% |
| 2. Pesquisar o produto | 20 | 9% |
| 3. Aplicar filtros | 98 | 42% |
| 4. Abrir detalhes | 37 | 16% |
| 5. Adicionar ao carrinho | 12 | 5% |
| 6. Simular compra | 23 | 10% |
| 7. Retornar à tela inicial | 12 | 5% |

## 8. Problemas de usabilidade encontrados

Gravidade na escala de Nielsen: 0 = não é problema, 1 = cosmético, 2 = pequeno, 3 = grande, 4 = catastrófico.

| Problema observado | Tarefa | Participantes afetados | Gravidade (0–4) | Recomendação |
| --- | --- | --- | --- | --- |
| A participante não encontrou onde ficam os filtros (entrega Full e ordenação) na versão para celular e desistiu da tarefa; só avançou com ajuda | 3 | 1 de 1 | 3 (grande) | Deixar os botões de filtrar e ordenar visíveis no topo da lista de resultados, com rótulos claros ("Filtrar", "Ordenar") |
| Dificuldade para digitar o termo em inglês "Bluetooth" na busca; precisou de ajuda | 2 | 1 de 1 | 2 (pequeno) | Destacar as sugestões de busca enquanto o usuário digita e aceitar grafias aproximadas do termo |

**Pontos positivos:** acessar o site, abrir os detalhes do produto, adicionar ao carrinho, iniciar a compra e voltar à tela inicial foram feitos sem ajuda e sem erros. Na tarefa 6, o preenchimento automático com os dados salvos na conta Google tornou a etapa de compra rápida (23 s).

## 9. Conclusão

- **Critérios do roteiro:** os dois critérios foram atingidos. A participante adicionou o produto ao carrinho (100%, meta de 90%) e concluiu o teste em 3min54s (meta de até 4 minutos). A margem do tempo foi pequena, de 6 segundos, e quase metade dele foi gasta na tarefa de filtros.
- **Ponto crítico, os filtros:** a participante não conseguiu filtrar por entrega Full e ordenar pelos melhores avaliados sem ajuda, e desistiu da tarefa. Também precisou de ajuda na busca, por causa da digitação de "Bluetooth". Por isso, a taxa de sucesso do fluxo completo sem ajuda foi 0%, mesmo com 5 das 7 tarefas concluídas sem ajuda.
- **Satisfação:** a nota SUS de 92,5 mostra uma percepção muito positiva do site, bem acima da referência de 68. O contraste com a dificuldade nos filtros indica que a participante, que já compra online, se sente à vontade no fluxo principal (buscar, abrir produto e comprar), e que o problema está em encontrar as opções de filtro e ordenação.
- **Recomendação principal:** tornar os filtros e a ordenação mais visíveis e fáceis de encontrar no celular.
- **Limitações:** o teste teve um único participante, então os percentuais (como os 90% de usuários que adicionam ao carrinho) não podem ser generalizados. Recomenda-se repetir o teste com pelo menos cinco participantes de perfis variados. Além disso, os dados salvos na conta Google da participante facilitaram a tarefa 6, o que deve ser considerado ao comparar o tempo dessa etapa.
