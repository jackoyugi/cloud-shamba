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

CREATE TABLE IF NOT EXISTS farmers (
id int PRIMARY KEY auto_increment,
name VARCHAR,
location VARCHAR,
contacts VARCHAR
);

CREATE TABLE IF NOT EXISTS feeds (
id int PRIMARY KEY auto_increment,
feed_type VARCHAR,
location VARCHAR,
price INTEGER,
quantity INTEGER
);

CREATE TABLE IF NOT EXISTS vaccinations (
id int PRIMARY KEY auto_increment,
vaccination_programme VARCHAR,
flock_number INTEGER
);

