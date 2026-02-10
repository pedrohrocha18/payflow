# PayFlow – Carteira Digital Simulada

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## Descrição

O **PayFlow** é uma API em Java com Spring Boot que simula uma carteira digital, permitindo:

- Cadastro de usuários
- Consulta de saldo
- Depósitos
- Transferências entre usuários
- Visualização de extrato

O projeto é voltado para **estudo e portfólio**, aplicando boas práticas de programação e persistência simples usando
arquivos `.txt`.

---

## Estrutura do Projeto

```com.payflow.payflow
├── controller # Endpoints da API
├── service # Regras de negócio e persistência
├── model # Entidades (User, Transaction)
├── dto # Objetos de transferência de dados
├── exception # Tratamento de exceções
```

---

## Tecnologias

- Java 17+
- Spring Boot
- Lombok
- Persistência em arquivos `.txt`
- BigDecimal para valores monetários
- Collections e Stream API

---

## Como Rodar

1. Clone o repositório:

```bash
git clone https://github.com/pedrohrocha18/payflow.git
```

2. Abra na sua IDE e rode:

```bash
./mvnw spring-boot:run
```

3. Teste os endpoints usando Postman ou Insomnia.

---- 

## Futuras Evoluções

| Funcionalidade                      | Descrição                                                         |
|-------------------------------------|-------------------------------------------------------------------|
| Persistência em banco de dados real | Implementar H2 ou PostgreSQL para armazenar dados permanentemente |
| Autenticação e segurança            | Adicionar JWT para proteger endpoints da API                      |
| Testes                              | Criar testes unitários e de integração para garantir estabilidade |
| DTOs detalhados                     | Melhorar respostas da API com DTOs claros e estruturados          |
