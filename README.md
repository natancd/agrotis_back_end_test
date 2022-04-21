# agrotis_back_end_test
API para ser utilizada na construção de uma tela, com base nos requisitos solicitados.

Linguagem: Java

Framework: Spring Boot

IDE utilizada: Eclipse

Caminho de acesso:
* **GET e POST**
http://localhost:8081/registros

* **GET, PUT e DELETE**
http://localhost:8081/registros/{id}


Arquivo SQL está em ```src/main/resources/```

Alguns detalhes não tratados no código, mas que sei que são necessários em uma aplicação robusta:

* tratamento mais específico de datas, seja para evitar datas incoerentes ou datas finais inferiores às datas iniciais e vice-versa
* controle das tabelas de Laboratório e Propriedade dentro das funcionalidades do CRUD
* segurança de dados para evitar que qualquer pessoa com o endereço possa realizar qualquer movimentação na API


Projeto desenvolvido com base no Curso "SPRING BOOT API REST: CONSTRUA UMA API" da Alura (https://cursos.alura.com.br/course/spring-boot-api-rest)
