# oficina-api — Avaliação 3 (PRW3)

API REST (Spring Boot + JPA + H2 + Flyway + Lombok) para registrar consertos de uma oficina.
Estrutura baseada no projeto `prw3_2026_1_api` visto em aula.

## Como rodar
```
./mvnw spring-boot:run
```
Console do H2: http://localhost:8080/h2-console (URL JDBC: `jdbc:h2:file:./DATA/oficina`, usuário `sa`, senha vazia).
Exemplos de requisições: `requests.http`.

## Endpoints
| Parte | Método | URL | Descrição | Resposta |
|---|---|---|---|---|
| 1 | POST | `/consertos` | Cadastra um conserto | 201 + `Location` |
| 2 | GET | `/consertos?page=&size=` | Todos os dados, paginado | 200 |
| 2/3 | GET | `/consertos/algunsdados` | id, datas, mecânico, marca e modelo (só ativos, sem paginação) | 200 |
| 3 | GET | `/consertos/{id}` | Um conserto | 200 / 404 |
| 3 | PUT | `/consertos` | Altera data de saída, nome e anos de experiência do mecânico | 200 / 404 |
| 3 | DELETE | `/consertos/{id}` | Exclusão lógica (`ativo = false`) | 204 / 404 |

## Migrations (Flyway)
- `V1` cria a tabela `consertos` (Veiculo e Mecanico são `@Embedded`)
- `V2` adiciona `cor` (opcional) ao veículo
- `V3` adiciona `ativo` (exclusão lógica)
