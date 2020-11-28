CREATE TABLE disciple  (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE technique (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
	disciple_id INT,
	foreign key (disciple_id) references disciple(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE authority (
	id INT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(255) NOT NULL,
	is_acc_non_expired BOOLEAN,
	is_acc_non_locked BOOLEAN,
	is_cred_non_expired BOOLEAN,
	is_enabled BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_authority (
	user_id INT,
    authority_id INT,
	foreign key (user_id) references user(id) ON DELETE CASCADE,
	foreign key (authority_id) references authority(id) ON DELETE CASCADE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO user (name, password) VALUES ("joss", "1234");
INSERT INTO user (name, password) VALUES ("dude", "4567");

INSERT INTO authority (role) VALUES ("ADMIN");
INSERT INTO authority (role) VALUES ("USER");

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);

ALTER TABLE authority
  MODIFY is_acc_non_expired BOOLEAN default false,
  MODIFY  is_acc_non_locked BOOLEAN default false,
	 MODIFY is_cred_non_expired BOOLEAN default false,
	 MODIFY is_enabled BOOLEAN default false;