insert into users (active, email, last_name, name, password) values (1, 'admin@email.com', 'admin', 'admin','$2a$10$cAUd2FPtDpYVaT3/23VPk.4ilA7KUBhV0kL.yPaoWftp0jxioke0K');
insert into users (active, email, last_name, name, password) values (1, 'user@email.com', 'user', 'user','$2a$10$cAUd2FPtDpYVaT3/23VPk.4ilA7KUBhV0kL.yPaoWftp0jxioke0K');

insert into roles (name) values ('ADMIN');
insert into roles (name) values ('USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1,1);
INSERT INTO users_roles (user_id, role_id) VALUES (2,2);

