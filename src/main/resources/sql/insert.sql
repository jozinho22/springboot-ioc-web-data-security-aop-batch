INSERT INTO user (name, password) VALUES ("joss", "1234");
INSERT INTO user (name, password) VALUES ("dude", "4567");

INSERT INTO user (name, password) VALUES ("dude", "4567");
INSERT INTO user (name, password, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ("jozinho", "1234", 1, 1, 1, 1);

INSERT INTO authority (role) VALUES ("ADMIN");
INSERT INTO authority (role) VALUES ("USER");

INSERT INTO users_authorities (user_id, authority_id) VALUES (1, 1);
INSERT INTO users_authorities (user_id, authority_id) VALUES (2, 2);

ALTER TABLE authority
  ADD is_account_non_expired BOOLEAN default false,
  ADD  is_account_non_locked BOOLEAN default false,
	 ADD is_credentials_non_expired BOOLEAN default false;
	 --ADD is_enabled BOOLEAN default false;


INSERT INTO disciple (name) values("jozinho");

INSERT INTO user (name, password, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ("jozinho", "1234", 1, 1, 1, 1);
INSERT INTO authority (role) VALUES ("ADMIN");
INSERT INTO authority (role) VALUES ("USER");
INSERT INTO users_authorities VALUES(1,1);
