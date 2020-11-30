CREATE TABLE reader (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE book (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
	reader_id INT,
	foreign key (reader_id) references reader(id),
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
	foreign key (role_id) references role(id) ON DELETE CASCADE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE permission (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_permissions (
	user_id INT,
    permission_id INT,
	foreign key (user_id) references user(id) ON DELETE CASCADE,
	foreign key (permission_id) references permission(id) ON DELETE CASCADE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO role (name) VALUES ("ADMIN");
INSERT INTO role (name) VALUES ("USER");

INSERT INTO permission (name) VALUES ("WRITE");
INSERT INTO permission (name) VALUES ("READ");

INSERT INTO user (name, password, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ("jozinho", "1234", 1, 1, 1, 1);
INSERT INTO users_roles VALUES(1,1);
INSERT INTO users_permissions VALUES(1,1);
