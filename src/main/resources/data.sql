insert into users (active, email, last_name, name, password) values (1, 'admin@email.com', 'admin', 'admin','$2a$10$cAUd2FPtDpYVaT3/23VPk.4ilA7KUBhV0kL.yPaoWftp0jxioke0K');
insert into users (active, email, last_name, name, password) values (1, 'user@email.com', 'user', 'user','$2a$10$cAUd2FPtDpYVaT3/23VPk.4ilA7KUBhV0kL.yPaoWftp0jxioke0K');
insert into users (active, email, last_name, name, password) values (1, 'adriano@email.com', 'adriano', 'avelino','$2a$10$cAUd2FPtDpYVaT3/23VPk.4ilA7KUBhV0kL.yPaoWftp0jxioke0K');
insert into users (active, email, last_name, name, password) values (1, 'tech@email.com', 'tech', 'Sauro','$2a$10$cAUd2FPtDpYVaT3/23VPk.4ilA7KUBhV0kL.yPaoWftp0jxioke0K');

insert into roles (name) values ('ADMIN');
insert into roles (name) values ('USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1,1);
INSERT INTO users_roles (user_id, role_id) VALUES (2,2);
INSERT INTO users_roles (user_id, role_id) VALUES (3,1);
INSERT INTO users_roles (user_id, role_id) VALUES (4,1);

insert into tickets (closed, created, description, finished, name, technician_id, user_id) values (null, '2020-10-13 19:56:28', 'decricao ticket 1', 0, 'nome do ticket', 3, 1 );
