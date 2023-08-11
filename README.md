## Exemplo de Testes Unitários para API Java com Spring Boot

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

### Objetivo:
  - A principal finalidade deste repositório é fornecer um ambiente de aprendizado e prática para desenvolvedores interessados em melhorar suas habilidades na criação de **Testes Unitários** em API's desenvolvidas em Java com Spring Boot.

### Descrição da API:
  - A API desenvolvida neste projeto é uma aplicação simples que gerencia recursos através de operações CRUD. Foi construída utilizando Java e Spring Boot.
  - A estrutura básica da API é a seguinte. Endpoint: **``{/users}``**

    | Rest  | Request         | Funcionalidade |
    |-------|-----------------| ------- |
    | GET   | /users          | Retorna a lista completa de usuários |
    | POST  | /users          | Cria um novo usuário |
    | GET   | /users/{id}     | Retorna dados de um usuário específico por ID |
    | DELETE | /users/{id}    | Remove um usuário específico por ID |
    | PUT   | /users/{id}     | Atualiza dados de um usuário específico por ID |

    #### Todos os endpoints estão disponíveis para testes, feedbacks e afins. Clique no botão abaixo para abrir no Postman.

    [![Run in Postman](https://run.pstmn.io/button.svg)](https://gold-eclipse-442776.postman.co/collection/19986209-8cf60a5b-66d7-4d0d-a0e3-9762c45b0b60?source=rip_markdown)

### Cobertura de Código:
  - Nesta etapa foi utilizado o **[Jacoco](https://www.eclemma.org/jacoco/)**, que gera relatórios detalhados que mostram a porcentagem de cobertura de código para diferentes partes do projeto, como classes, métodos e linhas de código. No plugin adicionado no arquivo `pom.xml` pode ser definido o limite de porcentagem a ser atingido pelo código.
  - No caso abaixo, as classes dos pacotes Model e DTO não atingiram um limite razoável (> 70%) por conta das anotações @ feitas no código que complementam outras etapas (endpoints) importantes, por exemplo construtores vazios, setters e outros.

    > Obs: Se você conhece alguma melhoria p/ esse caso, entre em contato ou faça uma contribuição seguindo os passos abaixo.     

    ![image](https://github.com/marcosrebelo97/starterkit-test/assets/37541973/4483fb5d-f047-4699-ac2e-98835571a972)

### Documentação
  - Nesta etapa tão importante, a ferramenta utilizada para documentar foi Swagger.
    
    ![image](https://github.com/marcosrebelo97/starterkit-test/assets/37541973/d42d7396-c7ea-4f8b-b685-88c29d02747b)


### Implantação
  - Para exercitar a prática de processo de deploy na nuvem, foi utilizado o [Raiway](https://railway.app/)
  - URL de acesso: [Clique aqui](https://starterkit-test-production.up.railway.app/users)

### Contribuindo:
  - Se você tiver algum feedback, melhorias possíveis, correção de bugs ou deseja adicionar novos testes, sinta-se à vontade para contribuir com este projeto. Siga os passos para contribuir.
     
  1. Faça um fork deste repositório para sua conta do GitHub
  2. Crir uma branch para sua feature ou correção
     
      ```bash
        git checkout -b minha-feature
      ```
      
  4. Faça as alterações necessárias e/ou adicione novos testes
  5. Commit as mudanças realizadas
     
       ```bash
          git commit -m "Descrição das alterações feitas"
       ```
       
  7. Push para o branch que você criou
     
     ```bash
          git push origin minha-feature
       ```
     
  9. Abra um Pull Request para este repositório, descrevendo suas altrações e explicando o motivo da contribuição.

### Material de Apoio:
  - [Documentação do JUnit](https://junit.org/junit5/docs/current/user-guide/)
  - [Documentação do Mockito](https://site.mockito.org/)
  - [Spring Boot Test - Documentação Oficial](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)

### Licença:
  - Este projeto está licenciado sob a [MIT License](https://opensource.org/license/mit/). 

      
