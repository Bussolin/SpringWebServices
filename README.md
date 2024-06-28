# SpringWebServices

Bem-vindo ao repositório **SpringWebServices**! Este projeto foi desenvolvido para demonstrar a implementação de serviços web utilizando o framework Spring. 

## Índice
- [Visão Geral](#visão-geral)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração](#configuração)
- [Endpoints](#endpoints)

## Visão Geral

O **SpringWebServices** é um projeto de exemplo que implementa uma API RESTful utilizando Spring Boot. Ele inclui funcionalidades básicas de CRUD (Create, Read, Update, Delete) para manipulação de dados, bem como exemplos de autenticação e autorização.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **H2 Database** (banco de dados em memória para desenvolvimento)
- **PostGres** (banco de dados hosteado na própria máquina)

## Configuração
### Configuração de Banco de Dados

Por padrão, o projeto está configurado para usar o banco de dados H2 em memória para fins de desenvolvimento. Para configurar um banco de dados diferente, edite o arquivo `application-"profile".properties` localizado em `src/main/resources`:

## Endpoints
O projeto inclui os seguintes endpoints REST:

Com 3 entidades (users, categories, products)

GET /api/"entidade" - Lista todos os usuários
POST /api/"entidade" - Cria um novo registro
GET /api/"entidade"/{id} - Obtém detalhes de um registro específico
PUT /api/"entidade"/{id} - Atualiza um registro existente
DELETE /api/"entidade"/{id} - Remove um registro

## Body

### POST

#### Users Example:
  
  {
   "name": "*User name*",
   "email": "*useremail@email.com*",
   "phone": "*User phone*",
   "password": "*User Password*"
  }

#### Category Example:

  {
   "name": "Category name"
  }

#### Products

  {
   "name": "*Product name*",
   "description": "*Product description*",
   "price": "*Product price(Double)*",
   "imgurl": "*Product image URL*"
  }

### PUT

  #### Users Example:
  
  {
   "name": "*User name*",
   "email": "*useremail@email.com*",
   "phone": "*User phone*",
  }

#### Category Example:

  *Same as POST Method*

#### Products

  *Same as POST Method*


Você pode testar os endpoints utilizando ferramentas como Postman ou cURL.

###Considerações

- **Licença**: Incluí a licença MIT como um exemplo. Verifique e altere se necessário.
- **Autenticação**: A autenticação mencionada é básica e pode ser ajustada conforme as especificidades do projeto.
- **Endpoints**: Incluí alguns endpoints de exemplo para ilustrar o uso da API. Adapte conforme necessário.
