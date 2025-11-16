 Projeto Java com JPA — CRUD, Banco de Dados e Modelagem

Este projeto foi desenvolvido durante o curso de Back-End com Java (SENAI), com o objetivo de aplicar conceitos de modelagem de dados, persistência com JPA/Hibernate e operações CRUD em diferentes contextos de negócio.

O sistema foi dividido em dois módulos principais:

Clínica Médica — gerenciamento de pacientes, médicos e consultas

E-commerce — controle de produtos, clientes e pedidos

Tecnologias utilizadas

Java 17+

Spring Boot (estrutura e injeção de dependência)

Spring Data JPA / Hibernate (persistência de dados)

PostgreSQL (banco de dados relacional)

Maven (gerenciador de dependências)

Lombok (para reduzir boilerplate)

Swagger / OpenAPI (documentação da API)

🩺 Módulo 1 — Clínica Médica

Modelagem voltada para o cadastro e controle de pacientes, médicos e consultas.

 Entidades principais:

Paciente → nome, CPF, telefone, histórico

Medico → nome, CRM, especialidade

Consulta → data, hora, médico, paciente

 Funcionalidades:

CRUD completo de pacientes, médicos e consultas

Relacionamento @ManyToOne entre Consulta, Paciente e Medico

Validação de dados (campos obrigatórios e formato de CPF)

Listagem de consultas por médico ou paciente

 Módulo 2 — E-commerce

Simulação de um pequeno sistema de loja virtual, com produtos, clientes e pedidos.

 Entidades principais:

Produto → nome, preço, categoria, estoque

Cliente → nome, e-mail, CPF

Pedido → data, valor total, lista de produtos

ItemPedido → quantidade e valor unitário

Funcionalidades:

CRUD de produtos, clientes e pedidos

Relacionamentos @OneToMany e @ManyToMany

Cálculo automático do valor total do pedido

Controle de estoque após finalização de compra

 Banco de Dados

PostgreSQL configurado no application.properties

Mapeamento objeto-relacional (ORM) com Hibernate

Criação automática de tabelas via spring.jpa.hibernate.ddl-auto=update

Chaves primárias geradas com @GeneratedValue

Relacionamentos mapeados com anotações JPA (@OneToMany, @ManyToOne, etc.)

O projeto foi desenvolvido com foco em:

Praticar arquitetura em camadas (Controller, Service, Repository)

Aplicar conceitos de modelagem relacional e JPA

Desenvolver APIs RESTful seguras e bem estruturadas

Aprender boas práticas de codificação e versionamento (Git/GitHub)

Criar módulo de relatórios com filtros avançados

Adicionar integração com serviços externos (ex: envio de e-mail)

Criar front-end em React ou Angular para consumo da API
