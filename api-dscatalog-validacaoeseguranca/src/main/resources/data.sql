INSERT INTO TB_USER(EMAIL, PASSWORD) VALUES ('ana@gmail.com', '$2a$12$l/3Ve97zm6UdyffaiE4WcOEBdRjmg/oPcdl2rMmzA7Dep6GYT8jpO');
INSERT INTO TB_USER(EMAIL, PASSWORD) VALUES ('bob@gmail.com', '$2a$12$l/3Ve97zm6UdyffaiE4WcOEBdRjmg/oPcdl2rMmzA7Dep6GYT8jpO');

INSERT INTO TB_ROLE(AUTHORITY) VALUES ('ROLE_CLIENT');
INSERT INTO TB_ROLE(AUTHORITY) VALUES ('ROLE_ADMIN');

INSERT INTO TB_USER_ROLE(ID_USER, ID_ROLE) VALUES (1, 1);
INSERT INTO TB_USER_ROLE(ID_USER, ID_ROLE) VALUES (2, 1);
INSERT INTO TB_USER_ROLE(ID_USER, ID_ROLE) VALUES (2, 2);

INSERT INTO tb_city(name) VALUES ('São Paulo');
INSERT INTO tb_city(name) VALUES ('Brasília');
INSERT INTO tb_city(name) VALUES ('Fortaleza');
INSERT INTO tb_city(name) VALUES ('Salvador');
INSERT INTO tb_city(name) VALUES ('Manaus');
INSERT INTO tb_city(name) VALUES ('Curitiba');
INSERT INTO tb_city(name) VALUES ('Goiânia');
INSERT INTO tb_city(name) VALUES ('Belém');
INSERT INTO tb_city(name) VALUES ('Porto Alegre');
INSERT INTO tb_city(name) VALUES ('Rio de Janeiro');
INSERT INTO tb_city(name) VALUES ('Belo Horizonte');


INSERT INTO tb_event(name, date, url, id_city) VALUES ('Feira do Software', '2021-05-16', 'https://feiradosoftware.com', 1);
INSERT INTO tb_event(name, date, url, id_city) VALUES ('CCXP', '2021-04-13', 'https://ccxp.com.br', 1);
INSERT INTO tb_event(name, date, url, id_city) VALUES ('Congresso Linux', '2021-05-23', 'https://congressolinux.com.br', 2);
INSERT INTO tb_event(name, date, url, id_city) VALUES ('Semana Spring React', '2021-05-03', 'https://devsuperior.com.br', 3);