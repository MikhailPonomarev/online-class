CREATE DATABASE IF NOT EXISTS onlineclass;

CREATE TABLE IF NOT EXISTS roles
(
    id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(30)
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    email CHARACTER VARYING(30) UNIQUE,
    last_name CHARACTER VARYING(30),
    first_name CHARACTER VARYING(30),
    middle_name CHARACTER VARYING(30),
    date_of_birth DATE,
    role_id INT,
    created_at DATE,
    updated_at DATE,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);
