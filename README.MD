# 101-proposta-case-cart-es -  Ayrton Saito
Projeto 101-proposta-case-cart-es

## How to run


```bash
./gradlew bootRun
```

## How to test
http://localhost:8080/swagger-ui.html#/

## Sample data
created by src/main/resouces/data.sql

#### clients
| ID | NAME |
| ------ | ------ |
| 10001 | João Machado |
| 10002 | Maria Diniz |
| 10003 | Marcelo Silva |

#### cards
| ID | CLIENT_ID | NUMBER |
| ------ | ------ | ------ |
| 100010 | 10001 | 1111222233334444 |
| 100020 | 10002 | 2222333344445555 |
| 100030 | 10003 | 3333444455556666 |

#### payments
| ID | CARD_ID |
| ------ | ------ |
| 1001 | 100010 |
| 1002 | 100020 |
| 1003 | 100030 |

