📚 Literalura - Catálogo de Livros e Autores (Gutendex API)

Este projeto foi desenvolvido como parte de um desafio de Java e Spring Boot, com o objetivo de construir um catálogo de livros e autores utilizando a API Gutendex (Project Gutenberg).
A aplicação permite buscar livros por título, listar livros e autores, salvar os dados em um banco de dados PostgreSQL e realizar consultas personalizadas.

🚀 Funcionalidades

🔍 Buscar livro por título na API Gutendex.

📖 Listar todos os livros já buscados.

👨‍💼 Listar autores salvos no sistema.

📅 Listar autores vivos em determinado ano.

🌎 Listar quantidade de livros por idioma.

💾 Persistência de dados com PostgreSQL utilizando Spring Data JPA.


🛠️ Tecnologias Utilizadas

Java 17+

Spring Boot 3

Spring Data JPA

PostgreSQL

HttpClient (Java 11+)

Jackson (para JSON)

⚙️ Configuração do Projeto
1. Clone o repositório:
git clone https://github.com/seu-usuario/Literalura.git
cd Literalura

2. Configure o banco de dados no arquivo application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Compile e execute o projeto:
./mvnw spring-boot:run

📖 Exemplos de Uso
Menu Interativo:

Ao rodar a aplicação, o usuário terá opções como:

Buscar livro por título

Listar todos os livros

Listar autores

Listar autores vivos em determinado ano

Listar quantidade de livros por idioma

Sair

🌐 API Utilizada

Gutendex API

Repositório: garethbjohnson/gutendex

📌 Próximos Passos

Adicionar testes unitários (JUnit + Mockito).

Criar interface gráfica (JavaFX ou Web com Spring MVC).

Implementar cache de resultados para melhorar desempenho.
