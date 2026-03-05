CREATE TABLE job (
  id BIGSERIAL PRIMARY KEY,
  profession VARCHAR(255),
  title VARCHAR(255),
  ref_nr VARCHAR(255) NOT NULL,
  external_source VARCHAR(255) NOT NULL,
  company VARCHAR(255),
  publish_date DATE,
  modification_date TIMESTAMP,

  area_postal_code VARCHAR(32),
  area_city VARCHAR(255),
  area_street VARCHAR(255),
  area_region VARCHAR(255)
);