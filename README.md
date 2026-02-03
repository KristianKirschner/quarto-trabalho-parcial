# Backend de E-commerce com Quarkus

Backend de um sistema de e-commerce desenvolvido em Java com Quarkus, com foco em boas práticas de desenvolvimento de APIs REST, organização de código e persistência de dados.

Este projeto foi desenvolvido como parte da disciplina Padrões de Desenvolvimento Web, ministrada pelo professor Sergio Delfino**.

---

## Funcionalidades

- Cadastro e gerenciamento de clientes
- Cadastro e gerenciamento de produtos
- Gerenciamento de categorias
- Criação e consulta de pedidos
- Pagamentos e entregas
- Carrinho de compras
- API REST documentada

---

## Tecnologias Utilizadas

- **Java 17**
- **Quarkus**
- **JPA / Hibernate (Panache)**
- **Maven**
- **OpenAPI / Swagger**
- **Docker Compose**
- **JUnit / RestAssured** (testes)

---

## Estrutura do Projeto

O projeto foi organizado seguindo boas práticas de separação de responsabilidades:

- **Resources (REST Controllers)** – Exposição dos endpoints da API
- **Entities** – Modelagem do domínio e persistência de dados
- **DTOs** – Objetos de transferência de dados para requisições e respostas
- **Testes** – Testes automatizados para validação de endpoints e persistência

---

## Documentação da API

A API é documentada utilizando **OpenAPI/Swagger**.

Após subir a aplicação, acesse:
- **Swagger UI:** `http://localhost:8080/swagger`
- **OpenAPI:** `http://localhost:8080/q/openapi`

---

## Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven
- Docker (opcional, para o banco de dados)

### Executando em modo desenvolvimento
```bash
./mvnw quarkus:dev
```

---

## Banco de Dados com Docker
O projeto possui um docker-compose para facilitar a execução do banco de dados localmente:
```bash
docker-compose up -d
```

---

## Testes
Os testes automatizados podem ser executados com:
```bash
./mvnw test
```
