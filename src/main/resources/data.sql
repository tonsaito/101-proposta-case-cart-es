-- Sample clients
insert into client(id, name) values(10001, 'João Machado');
insert into client(id, name) values(10002, 'Maria Diniz');
insert into client(id, name) values(10003, 'Marcelo Silva');

-- Sample cards
insert into card(id, client_id, number, status) values(100010, 10001, '1111222233334444', false);
insert into card(id, client_id, number, status) values(100020, 10002, '2222333344445555', false);
insert into card(id, client_id, number, status) values(100030, 10003, '3333444455556666', false);