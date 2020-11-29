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
	is_account_non_expired BOOLEAN default 0,
	is_account_non_locked BOOLEAN default 0,
	is_credentials_non_expired BOOLEAN default 0,
	is_enabled BOOLEAN default 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE role (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_roles (
	user_id INT,
    role_id INT,
	foreign key (user_id) references user(id) ON DELETE CASCADE,
	foreign key (authority_id) references authority(id) ON DELETE CASCADE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO role (name) VALUES ("ADMIN");
INSERT INTO role (name) VALUES ("USER");

