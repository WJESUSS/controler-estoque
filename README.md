# Controle de Estoque Simples - Spring Boot 3

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=for-the-badge&logo=spring-boot)
![H2](https://img.shields.io/badge/H2-Database-blue?style=for-the-badge&logo=h2)
![Maven](https://img.shields.io/badge/Maven-3.8%2B-C71A36?style=for-the-badge&logo=apache-maven)

> **Projeto perfeito para desenvolvedores Júnior, portfólio e entrevistas técnicas**  
> Demonstra domínio dos conceitos fundamentais de Spring Boot: REST API, JPA, validações, arquitetura em camadas e boas práticas.

## ✨ Funcionalidades Implementadas

- CRUD completo de produtos
- Controle de entrada e saída de estoque com validação de quantidade disponível
- Validações robustas com **Bean Validation** (`@NotBlank`, `@Positive`, `@Min`, etc.)
- Tratamento básico de exceções
- Banco de dados em memória **H2** (zero configuração)
- Código limpo e organizado em camadas: `Controller → Service → Repository`
- Uso moderno de **DTOs com `record`** (Java 16+)

## 🚀 Endpoints da API

| Método | Endpoint                    | Descrição                          | Body Exemplo                  |
|--------|-----------------------------|------------------------------------|-------------------------------|
| POST   | `/api/produtos`             | Criar produto                      | JSON completo                 |
| GET    | `/api/produtos`             | Listar todos os produtos           | -                             |
| GET    | `/api/produtos/{id}`        | Buscar produto por ID              | -                             |
| PUT    | `/api/produtos/{id}`        | Atualizar produto                  | JSON completo                  |
| DELETE | `/api/produtos/{id}`        | Excluir produto                    | -                             |
| PATCH  | `/api/produtos/{id}/entrada`| Adicionar quantidade ao estoque    | `150` (número inteiro)        |
| PATCH  | `/api/produtos/{id}/saida`  | Remover quantidade do estoque      | `30` (número inteiro)         |

> **Importante**: A saída de estoque falha com erro claro se não houver quantidade suficiente!

## 🛠 Tecnologias Utilizadas

- Spring Boot 3.x
- Java 17+
- Spring Data JPA + Hibernate
- H2 Database (em memória)
- Lombok
- Bean Validation (Jakarta Validation)
- Maven

## ⚙️ Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- Qualquer IDE (IntelliJ IDEA, Eclipse, VS Code + Java extensions)

## ▶️ Como Executar

```bash
# 1. Clone o repositório
git clone https://github.com/WashingtonSantosDev/controle-estoque-spring.git
cd controle-estoque-spring

# 2. Execute com Maven
./mvnw spring-boot:run
# ou
mvn spring-boot:run


API disponível em: → http://localhost:8080
Console H2 (visualizar dados): → http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:estoquedb | Usuário: sa | Senha: (em branco)

📝 Exemplos de Requisições
Criar Produto
JSONPOST /api/produtos
{
  "nome": "Teclado Mecânico",
  "descricao": "Switch azul, RGB, layout ABNT2",
  "preco": 329.90,
  "quantidade": 45
}
Entrada de Estoque
BashPATCH /api/produtos/1/entrada
150
Saída de Estoque
BashPATCH /api/produtos/1/saida
30
🏗 Estrutura do Projeto
textsrc/main/java/com/estoque/
├── EstoqueApplication.java
├── controller/    → ProdutoController.java
├── service/       → ProdutoService.java
├── model/         → Produto.java (entidade JPA)
├── dto/           → ProdutoDTO.java (record)
└── repository/    → ProdutoRepository.java
🔮 Possíveis Melhorias Futuras (já planejadas!)

Tratamento global de exceções com @RestControllerAdvice
Paginação e filtros na listagem
Documentação automática com SpringDoc OpenAPI + Swagger UI
Testes unitários e de integração (JUnit 5 + MockMvc)
Segurança com Spring Security + JWT
Migração para PostgreSQL/MySQL em produção
Docker + docker-compose
Frontend em React ou Angular

👨‍💻 Autor
Feito com carinho por Washington Santos
GitHub
LinkedIn
Qualquer dúvida, sugestão ou quer trocar uma ideia? Abre uma issue ou me chama! ☕
Happy coding! 🚀
text### Dicas finais:
- Troque `WashingtonSantosDev` pelo seu usuário real do GitHub
- Adicione o link correto do LinkedIn
- Se quiser ficar ainda mais lindo, adicione uma imagem do projeto (ex: screenshot do Swagger ou Postman) no topo com:
```markdown
![Demo](demo.png)
