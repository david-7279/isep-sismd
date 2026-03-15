# Projeto — Sistema de Leilões Concorrente

## Contexto

Implemente um sistema de leilões online onde múltiplos utilizadores podem fazer licitações (bids) em diferentes itens ao
mesmo tempo.

O sistema deve garantir que:

- o maior lance vence
- não existem race conditions
- múltiplas threads podem licitar concorrentemente

## Objetivo

Desenvolver uma aplicação multithread onde:

- vários utilizadores tentam licitar no mesmo item
- o sistema mantém sempre o maior lance válido
- a concorrência é controlada com locks ou synchronized

---

## Requisitos

### 1. Item de leilão

Criar uma classe:

`AuctionItem`

com:

- id
- name
- currentHighestBid
- currentWinner
- lock

Responsabilidades:

- guardar o maior lance
- garantir acesso concorrente seguro

---

### 2. Bid (licitação)

Criar uma classe:

`Bid`

com:

- userId
- amount
- timestamp

---

### 3. Serviço de leilões

Criar uma classe:

`AuctionService`

responsável por:

- placeBid(item, bid)

Regras:

- um bid só é aceite se for maior que o atual
- apenas uma thread pode atualizar o item de cada vez
- garantir consistência do vencedor

---

### 4. Threads de utilizadores

Criar uma classe:

`Bidder`

Cada thread representa um utilizador do leilão.

A thread deve:

1. escolher um item aleatório
2. gerar um valor de bid aleatório
3. tentar fazer bid
4. repetir várias vezes

---

## Desafios de concorrência

O sistema deve evitar:

### Race condition

Exemplo errado:

```text
Thread1: lê bid atual = 100
Thread2: lê bid atual = 100

Thread1: escreve 120
Thread2: escreve 110
```

Resultado incorreto:

```text
110 vence
```

---

### Starvation

Algumas threads podem tentar licitar continuamente.

---

### Deadlock

Se decidires usar múltiplos locks para itens diferentes.