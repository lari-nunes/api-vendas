# API RESTful de Vendas 🛒 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Este projeto é uma API que permite cadastrar clientes, categorias, produtos e suas respectivas vendas, construída usando **Java, Spring Boot, PostgreSQL, Autorização, Autenticação e JWT Tokens.**

## Índice
- [Instalação](#installation)
- [Acessar Projeto](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/Fernanda-Kipper/desafio-anotaai-backend.git
```

2. Instale dependências com Maven

## Acessar Projeto

1. Inicie o aplicativo com Maven
2. A API estará acessível em http://localhost:8080

## API Endpoints
A API fornece os seguintes endpoints:

**API PRODUTO**
```markdown
POST /product - Criar um novo produto
GET /product - Buscar todos os produtos
PUT /product/{id} - Atualizar um produto
DELETE /product/{id} - Excluir um produto
```

**BODY**
```json
{
  {
	"id": "bcb46d16-210c-4f6a-9d4f-ac81b895402d",
	"name": "Arroz branco",
	"price": 8.50,
	"dt_validade": "2024-06-06",
	"categoria": {
    "id_categoria": 1
  }
}
```

**API CATEGORIA**
```markdown
POST /categoria - Criar uma nova categoria
GET /categoria - Listar todas as categorias
PUT /categoria/{id} - Atualizar uma categoria
DELETE /categoria/{id} - Deletar uma categoria
```

**BODY**
```json
{
  "id": 1,
  "nome": "Alimentos"
}
```

**API PESSOA**
```markdown
POST /pessoa - Criar uma nova pessoa
GET /pessoa - Listar todas as pessoas
PUT /pessoa/{id} - Atualizar uma pessoa
DELETE /pessoa/{id} - Deletar uma pessoa
```

**BODY**
```json
{
  "id_cliente": 1,
  "nm_cliente": "Maria",
  "nr_telefone": "9999-9999",
  "nr_ddd": "44",
  "ds_endereco": "Rua 1"
}
```

**API VENDA**
```markdown
POST /venda - Criar uma nova venda
GET /venda - Listar todas as venda
PUT /venda/{id} - Atualizar uma venda
DELETE /venda/{id} - Deletar uma venda
```

**BODY**
```json
{
  "id_venda": 1,
  "dt_venda": "2023-11-07",
  "pessoa": {
		"id_cliente": 1
	}
}
```
- Para acessar endpoints protegidos como usuário ADMIN, forneça as credenciais de autenticação apropriadas no cabeçalho da solicitação.


## Database

O projeto utiliza [PostgresSQL](https://www.postgresql.org/) como banco de dados. As migrations de banco de dados necessárias são gerenciadas usando Flyway.

