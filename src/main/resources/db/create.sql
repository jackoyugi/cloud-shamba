SET MODE postgreSQL;

CREATE TABLE IF NOT EXISTS animals (
id int PRIMARY KEY auto_increment,
animal_type VARCHAR
);

CREATE TABLE IF NOT EXISTS diagnosis (
id int PRIMARY KEY auto_increment,
sex VARCHAR,
age VARCHAR,
breed VARCHAR,
location VARCHAR,
clinical_signs VARCHAR,
herd_number INTEGER,
number_sick INTEGER,
number_dead INTEGER,
photo_url BLOB
);

