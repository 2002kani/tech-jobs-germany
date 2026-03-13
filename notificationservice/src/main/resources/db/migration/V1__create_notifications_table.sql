CREATE TABLE notification (
    id                BIGSERIAL PRIMARY KEY,
    profession        VARCHAR(255),
    title             VARCHAR(255),
    ref_nr            VARCHAR(255) NOT NULL UNIQUE,
    external_source   VARCHAR(255),
    area_postal_code  VARCHAR(20),
    area_city         VARCHAR(255),
    area_street       VARCHAR(255),
    area_region       VARCHAR(255),
    company           VARCHAR(255),
    publish_date      DATE,
    modification_date TIMESTAMP,
    email_sent        BOOLEAN NOT NULL DEFAULT FALSE
);
