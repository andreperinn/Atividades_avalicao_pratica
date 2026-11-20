# Roteiro do avaliador — Teste de Usuário Final (Mercado Livre)

Este roteiro padroniza a aplicação do teste para que todas as sessões sejam conduzidas do mesmo jeito. Os resultados são registrados em [`planilha_teste_usuario.xlsx`](planilha_teste_usuario.xlsx) (abas **Observação** e **SUS**).

## Papéis

| Papel | Quem | O que faz |
| --- | --- | --- |
| Usuário final | Aluno participante | Executa as tarefas como comprador |
| Avaliador | Colega | Lê as instruções, cronometra, observa e registra tempo, erros e comentários |
| Instrutor | Professor | Orienta e supervisiona o teste |

## 1. Antes das sessões (piloto, feito uma vez pelo avaliador)

Faça o fluxo completo sozinho, sem cronometrar, para conhecer o caminho esperado e descobrir pontos que podem travar os participantes:

- [ ] Confirmar onde fica o filtro de **entrega Full** na página de resultados.
- [ ] Verificar se existe a opção de **ordenar pelos melhores avaliados**. Se o site não tiver essa ordenação, **não avise o participante**: observe como ele tenta cumprir a tarefa e registre como problema de usabilidade/divergência entre tarefa e interface.
- [ ] Verificar se **adicionar ao carrinho** ou **iniciar a compra** exige login. Defina antes das sessões como isso será tratado (por exemplo: a tarefa 6 termina quando aparece a tela de login ou de pagamento) e use o mesmo critério para todos.
- [ ] Preparar o navegador: janela anônima (sem histórico, sem carrinho anterior), zoom em 100% e o site fechado.

## 2. Preparação de cada sessão

- [ ] Abrir a planilha na aba **Observação** e localizar as linhas do participante (P1, P2...).
- [ ] Cronômetro zerado (celular ou computador).
- [ ] Navegador em janela anônima, na página em branco.
- [ ] Pedir permissão ao participante para registrar tempos e comentários (sem dados pessoais).

## 3. Fala de abertura (ler para o participante)

> "Obrigado por participar. Vamos avaliar o site, não você: não existe resposta errada. Você está procurando um fone de ouvido sem fio para uso diário e quer comprar pelo Mercado Livre. Vou te passar uma tarefa por vez. Faça como faria normalmente e, se puder, fale em voz alta o que está pensando. Eu não posso te ajudar durante as tarefas, a não ser que você fique travado. Não vamos finalizar nenhum pagamento. Podemos começar?"

## 4. Tarefas (ler uma por vez)

| Nº | Instrução para o participante | Considera concluída quando |
| --- | --- | --- |
| 1 | Acesse o site do Mercado Livre. | A página inicial do mercadolivre.com.br carregou |
| 2 | Pesquise por "fone de ouvido Bluetooth". | A lista de resultados da busca aparece |
| 3 | Use os filtros para mostrar apenas produtos com entrega Full e ordene pelos melhores avaliados. | Filtro Full aplicado e ordenação escolhida (ver piloto) |
| 4 | Escolha um produto e acesse os detalhes dele. | A página do produto está aberta |
| 5 | Adicione o item ao carrinho. | O produto aparece no carrinho / confirmação de adicionado |
| 6 | Simule o início da compra, sem concluir o pagamento. | Chegou à etapa de compra definida no piloto |
| 7 | Volte para a tela inicial. | A página inicial está aberta novamente |

## 5. Durante a sessão: o que registrar

- **Tempo (s):** inicie o cronômetro ao terminar de ler cada tarefa e pare quando ela for concluída (ou abandonada). Anote o tempo de cada tarefa; o tempo total é somado pela planilha.
- **Concluiu (S/N):** S se a tarefa foi concluída, mesmo com ajuda; N se o participante desistiu.
- **Precisou de ajuda (S/N):** S se você teve que intervir. Só ajude se o participante pedir ajuda duas vezes ou ficar mais de 2 minutos sem avançar.
- **Nº de erros:** conte cada ocorrência de:
  - clique em elemento errado (link, filtro ou botão que não leva ao objetivo);
  - perda do caminho (voltar páginas, recomeçar a busca);
  - confusão nos filtros (aplicar filtro errado, não encontrar o filtro, desfazer filtro).
- **Observações:** frases do participante, hesitações, onde procurou primeiro, elementos que confundiram.

Não corrija, não aponte e não confirme se o participante está no caminho certo. Respostas neutras: "Faça como achar melhor."

## 6. Depois das tarefas

1. Aplicar o questionário SUS ([`questionario_sus.md`](questionario_sus.md)) e registrar as 10 respostas na aba **SUS**.
2. Perguntas abertas (anotar nas observações da tarefa 7):
   - O que foi mais difícil?
   - O que você mudaria no site?
3. Agradecer e fechar a janela anônima (o carrinho não fica salvo).

## 7. Depois de todas as sessões

1. Conferir a aba **Resumo** da planilha: as métricas e os critérios de sucesso são calculados automaticamente.
2. Copiar os números para a seção de resultados do [`README.md`](README.md).
3. Listar os problemas de usabilidade observados, quantos participantes cada um afetou e a gravidade.
