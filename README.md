# 🧩 Pokédex API

API REST para gerenciamento de Pokémon, desenvolvida com Java e Spring Boot.

O projeto foi desenvolvido com foco em boas práticas de desenvolvimento, separação de responsabilidades e organização arquitetural, utilizando Clean Architecture, PostgreSQL, Flyway, Docker e OpenAPI/Swagger.

---

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.5.16
- Spring Web
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Flyway
- Lombok
- Mockito
- JUnit
- OpenAPI / Swagger
- Maven
- Docker
- Docker Compose

---

## 🏗️ Arquitetura

O projeto utiliza **Clean Architecture**, buscando manter as regras de negócio independentes de frameworks e detalhes de infraestrutura.

A estrutura principal da aplicação está organizada em:

```text
src
└── main
    ├── java
    │   └── com.matheus.pokedexapi
    │       ├── application
    │       ├── domain
    │       ├── infrastructure
    │       └── interfaces
    │
    └── resources