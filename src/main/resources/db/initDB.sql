DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL,
    CONSTRAINT restaurant_name_idx UNIQUE (name)
);

CREATE TABLE dishes
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name          VARCHAR NOT NULL,
    price         NUMERIC,
    restaurant_id INTEGER NOT NULL,
    CONSTRAINT dish_name_idx UNIQUE (name, restaurant_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE menus
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    dish_id       INTEGER                           NOT NULL,
    restaurant_id INTEGER                           NOT NULL,
    date          TIMESTAMP           DEFAULT now() NOT NULL,
    FOREIGN KEY (dish_id) REFERENCES dishes ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX menus_dish_restaurant_date_idx ON menus (dish_id, restaurant_id, date);

CREATE TABLE votes
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id       INTEGER                           NOT NULL,
    restaurant_id INTEGER                           NOT NULL,
    date          TIMESTAMP           DEFAULT now() NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX votes_user_restaurant_date_idx ON votes (user_id, restaurant_id, date);

