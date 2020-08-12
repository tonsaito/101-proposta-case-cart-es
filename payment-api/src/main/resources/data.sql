-- Sample clients
insert into client(id, name) values(10001, 'João Machado');
insert into client(id, name) values(10002, 'Maria Diniz');
insert into client(id, name) values(10003, 'Marcelo Silva');

-- Sample cards
insert into card(id, client_id, number, status) values(100010, 10001, '1111222233334444', false);
insert into card(id, client_id, number, status) values(100020, 10002, '2222333344445555', false);
insert into card(id, client_id, number, status) values(100030, 10003, '3333444455556666', false);

-- Sample payments
insert into payment(id, card_id, description, value) values(1001, 100010, 'Cerveja', 10.55);
insert into payment(id, card_id, description, value) values(1002, 100020, 'Marmita', 25.54);
insert into payment(id, card_id, description, value) values(1003, 100030, 'TV LCD 55', 2510.0);