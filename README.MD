# 101-proposta-case-cart-es -  Ayrton Saito (Microservices version)
Projeto 101-proposta-case-cart-es

exercise url: https://gitlab.com/itau-spec-4/101-proposta-case-cart-es

## How to run

#### Consul cluster
docker-compose up

#### Each microservice

```bash
./gradlew bootRun
```

## How to test
(consul server) http://localhost:8500/ <br>


(client-api) http://localhost:5000/swagger-ui.html#/ <br>
(card-api) http://localhost:5100/swagger-ui.html#/ <br>
(payment-api) http://localhost:5200/swagger-ui.html#/ <br>

## Sample data
created by src/main/resouces/data.sql (on each microservice)

#### clients
| ID | NAME |
| ------ | ------ |
| 10001 | João Machado |
| 10002 | Maria Diniz |
| 10003 | Marcelo Silva |

#### cards
| ID | CLIENT_ID | NUMBER | STATUS |
| ------ | ------ | ------ | ------ | 
| 100010 | 10001 | 1111222233334444 | true |
| 100020 | 10002 | 2222333344445555 | true |
| 100030 | 10003 | 3333444455556666 | false |

#### payments
| ID | CARD_ID |
| ------ | ------ |
| 1001 | 100010 |
| 1002 | 100020 |
| 1003 | 100030 |

