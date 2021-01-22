# helpdesk-schoolofnet

<p>
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/my-study-area/helpdesk-schoolofnet">
    <a href="https://github.com/my-study-area">
        <img alt="Made by" src="https://img.shields.io/badge/made%20by-adriano%20avelino-gree">
    </a>
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/my-study-area/helpdesk-schoolofnet">
    <a href="https://github.com/EliasGcf/readme-template/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/my-study-area/helpdesk-schoolofnet">
    </a>
</p>

Projeto desenvolvido durante o Curso Criando um Helpdesk com SpringBoot e MySQL da School of Net.

Durante o curso foi desenvolvido um sistema Helpdesk (Atendimento de chamados) que inclui uma área administrativa para análise e métricas do helpdesk. Parte gerencial, onde é possível administrar usuários e chamados. Àrea do usuário para abrir, listar e interagir com o chamado através de comentários, avaliação e envio dos dados para o suporte e área de relatório de chamados com filtros.

<image src="src/main/resources/static/img/app.png" alt="Imagem da aplicação desenvolvida durante o curso">

## Tecnologias
- Java 8
- Spring Boot
- Spring Data
- Thymeleaf
- Mysql
- Bootstrap 4

Atualizações:
- dockerização do banco de dados Mysql

## Começando
```bash
#clone o projeto
git clone https://github.com/my-study-area/helpdesk-schoolofnet.git

#entre no diretório
cd helpdesk-schoolofnet/

#inicie o banco de dados
docker-compose up

#inicie a aplicação
./gradlew bootRun
```
O sistema pode ser acessado através do endereço: [http://localhost:8080/login](http://localhost:8080/login)

Lista de usuários para teste no sistema:

| Usuário        |  Senha |
| -------------- | ------ |
|admin@email.com | 123123 |
|user@email.com  | 123123 |
|tech@email.com  | 123123 |
