# 🛍️ Store API (E-Commerce Back-End)

API RESTful desenvolvida com **Java 17** e **Spring Boot** para gerenciamento de catálogo, controle de estoque e processamento de compras para e-commerce. A aplicação conta com persistência em banco de dados relacional **MySQL** e suporte a upload/serviço de arquivos estáticos (imagens em formato JPEG).

---

## 🚀 Tecnologias e Ferramentas

* **Java 17** / **Spring Boot 3**
* **Spring Data JPA** / **Hibernate**
* **MySQL** (Banco de dados relacional)
* **Lombok** (Redução de código boilerplate)
* **Maven** (Gerenciador de dependências)

---

## 🏛️ Arquitetura e Boas Práticas

* **Padrão DTO (Data Transfer Object):** Separação clara entre a camada de apresentação/contratos REST e as entidades de domínio JPA (`ProductRequestDTO`, `ProductResponseDTO`, etc.).
* **Tratamento de Upload de Mídias:** Armazenamento de arquivos no sistema de arquivos local com geração de identificadores únicos via `UUID` para evitar colisão de nomes.
* **Mapeamento de Relacionamentos:** Relacionamento `1:1` (`@OneToOne`) em cascata entre `Product` e `Image`.
* **Baixo Acoplamento:** Injeção de dependências do Spring (`@RequiredArgsConstructor`) e arquitetura em camadas (Controllers, Services, Repositories e Entities).

---

## 📋 Pré-requisitos

* **JDK 17** ou superior instalado.
* **MySQL Server** em execução (com a database/schema `store` criada).
* **Maven** (opcional, caso utilize o wrapper `./mvnw` ou IDE integrada).

---

## 🔧 Configuração e Execução

1. Clone o repositório:
   ```bash
   git clone [https://github.com/Mayconfuzita86/API_STORE.git](https://github.com/Mayconfuzita86/API_STORE.git)
