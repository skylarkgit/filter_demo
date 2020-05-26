DROP TABLE IF EXISTS entityb;
DROP TABLE IF EXISTS entitya;

CREATE TABLE entitya (id BIGSERIAL NOT NULL PRIMARY KEY, is_active BOOLEAN DEFAULT true NOT NULL, status TEXT NOT NULL);
CREATE TABLE entityb (id BIGSERIAL NOT NULL PRIMARY KEY, is_active BOOLEAN DEFAULT true NOT NULL, name TEXT NOT NULL,
					  a_id BIGINT NOT NULL, FOREIGN KEY (a_id) REFERENCES entitya(id));
					 
INSERT INTO entitya (status) VALUES ('pending');