# 101-proposta-case-cart-es -  Ayrton Saito (Microservices version)
Projeto 101-proposta-case-cart-es

exercise url: https://gitlab.com/itau-spec-4/101-proposta-case-cart-es

## How to run
on docker-compose.yml change the following params:

| VARIABLE                         | VALUE                 | EXAMPLE     |
| -------------------------------- | --------------------- | ----------- |
| SERVICE_DISCOVERY_SERVER_ADDRESS | Your local IP ADDRESS | 192.168.0.2 |
| LOCAL_ADDRESS                    | Your local IP ADDRESS | 192.168.0.2 |

then run:
```sh
$ docker-compose up
``` 

## Docker compose content:
- consul <br>
    https://hub.docker.com/_/consul
- docker.io/tonsaito/mtc-client-api:latest <br>
    https://hub.docker.com/repository/docker/tonsaito/mtc-client-api
- docker.io/tonsaito/mtc-card-api:latest <br>
    https://hub.docker.com/repository/docker/tonsaito/mtc-card-api
- docker.io/tonsaito/mtc-payment-api:latest <br>
    https://hub.docker.com/repository/docker/tonsaito/mtc-payment-api

### Note
Since all microservices are using H2 embbeded database, doesn't make sense
to run more than 1 instance of client and card services, excepto for payment service.


## How to test
(consul server) http://localhost:8500/ <br>

(client-api) http://localhost:5000/swagger-ui.html#/ <br>
(card-api) http://localhost:5100/swagger-ui.html#/ <br>
(payment-api) http://localhost:5200/swagger-ui.html#/ && http://localhost:5201/swagger-ui.html#/ <br>

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

