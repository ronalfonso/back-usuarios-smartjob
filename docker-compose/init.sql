CREATE SCHEMA auths;

CREATE TABLE IF NOT EXISTS auths.users
(
    id       UUID PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    created  timestamp    NOT NULL,
    modified timestamp    NOT NULL
);

CREATE TABLE IF NOT EXISTS auths.phones
(
    id           UUID PRIMARY KEY,
    number       VARCHAR(18),
    city_code    VARCHAR(3),
    country_code VARCHAR(4)
);

CREATE TABLE IF NOT EXISTS auths.auth
(
    id         UUID PRIMARY KEY,
    password   VARCHAR(255) NOT NULL,
    token      VARCHAR(255),
    is_active  BOOLEAN      default true,
    last_login timestamp,
    FOREIGN KEY (id) REFERENCES auths.users (id)
);

CREATE TABLE IF NOT EXISTS auths.users_phones
(
    user_id       UUID,
    phone_id      UUID
);


-- CREATE TABLE IF NOT EXISTS accounts.cuentas
-- (
--     id            serial PRIMARY KEY,
--     numero_cuenta integer NOT NULL UNIQUE,
--     saldo_inicial integer NOT NULL,
--     estado        boolean NOT NULL DEFAULT TRUE,
--     cliente_id    integer NOT NULL
-- );

-- CREATE TABLE IF NOT EXISTS accounts.movimientos
-- (
--     id              serial PRIMARY KEY,
--     fecha           timestamp NOT NULL,
--     tipo_movimiento varchar   NOT NULL,
--     valor           numeric   NOT NULL,
--     saldo           numeric   NOT NULL,
--     cuenta_id       integer   NOT NULL,
--     FOREIGN KEY (cuenta_id) REFERENCES accounts.cuentas (id)
-- );

-- CREATE TABLE IF NOT EXISTS accounts.tipo_cuentas
-- (
--     id     serial PRIMARY KEY,
--     nombre varchar NOT NULL
-- );

-- ALTER TABLE accounts.cuentas
--     ADD COLUMN tipo_cuenta_id integer,
--     ADD FOREIGN KEY (tipo_cuenta_id) REFERENCES accounts.tipo_cuentas (id);

-- Inserts a new tipo_cuenta
-- INSERT INTO accounts.tipo_cuentas
-- VALUES (1, 'AHORRO');
-- INSERT INTO accounts.tipo_cuentas
-- VALUES (2, 'CORRIENTE');

-- Inserts a new person
-- INSERT INTO clients.personas VALUES (1, 'Jose Lema', 'MASCULINO', 35, 654665, 'Otavalo sn y principal', '098254785');
-- INSERT INTO clients.personas VALUES (2, 'Marianela Montalvo', 'FEMENINO', 25, 785954, 'Amazonas Y NNUU', '097548965');
-- INSERT INTO clients.personas VALUES (3, 'Juan Osorio', 'MASCULINO', 28, 567977, '13 junio y Equinnoccial', '098874587');
--
-- -- Inserts a new client
-- INSERT INTO clients.clientes VALUES (1, '1234', true, 1);
-- INSERT INTO clients.clientes VALUES (2, '5678', true, 2);
-- INSERT INTO clients.clientes VALUES (3, '1245', true, 3);
--
-- -- Inserts a new account
-- INSERT INTO accounts.cuentas VALUES (1, 478758, 2000, true, 1, 1);
-- INSERT INTO accounts.cuentas VALUES (2, 225487, 100, true, 2, 2);
-- INSERT INTO accounts.cuentas VALUES (3, 495878, 0, true, 3, 1);
-- INSERT INTO accounts.cuentas VALUES (4, 496825, 540, true, 2, 1);