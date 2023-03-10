CREATE DATABASE IF NOT EXISTS agrismart;

CREATE TABLE IF NOT EXISTS farm (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS animal_type (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS animal_breed (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255)  NOT NULL,
  type_id INT NOT NULL,
  FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

CREATE TABLE IF NOT EXISTS animal (
  id INT PRIMARY KEY AUTO_INCREMENT,
  farm_id INT  NOT NULL,
  code VARCHAR(255) NOT NULL, 
  name VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  breed_id INT NOT NULL,
  sex VARCHAR(255) NOT NULL,
  weight FLOAT NOT NULL,
  status VARCHAR(255) NOT NULL,
  UNIQUE (code, farm_id),
  FOREIGN KEY (farm_id) REFERENCES farm(id),
  FOREIGN KEY (breed_id) REFERENCES animal_breed(id)
);

CREATE TABLE IF NOT EXISTS food (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  cost FLOAT NOT NULL,
  unit VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS nutrition (
  id INT PRIMARY KEY AUTO_INCREMENT,
  food_id INT NOT NULL,
  quantity FLOAT NOT NULL,
  unit VARCHAR(255) NOT NULL,
  frequency INT NULL,
  animal_type_id INT NOT NULL,
  FOREIGN KEY (animal_type_id) REFERENCES animal_type(id),
  FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE IF NOT EXISTS animal_nutrition (
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_id INT NOT NULL,
  nutrition_id INT NOT NULL,
  date DATE NOT NULL,
  quantity FLOAT NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animal(id),
  FOREIGN KEY (nutrition_id) REFERENCES nutrition(id)
);

CREATE TABLE IF NOT EXISTS animal_health (
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_id INT NOT NULL,
  date DATE NOT NULL,
  description VARCHAR(255) NOT NULL,
  treatment VARCHAR(255) NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE IF NOT EXISTS animal_vaccine (
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_id INT NOT NULL,
  date DATE NOT NULL,
  vaccine VARCHAR(255) NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE IF NOT EXISTS animal_pregnancy (
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_id INT NOT NULL,
  date DATE NOT NULL,
  status VARCHAR(255) NOT NULL,
  due_date DATE NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE IF NOT EXISTS animal_milk (
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_id INT NOT NULL,
  date DATE NOT NULL,
  quantity FLOAT NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE IF NOT EXISTS pasture (
  id INT PRIMARY KEY AUTO_INCREMENT,
  farm_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  area FLOAT NOT NULL,
  FOREIGN KEY (farm_id) REFERENCES farm(id)
);

CREATE TABLE IF NOT EXISTS animal_location (
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_id INT NOT NULL,
  date DATE NOT NULL,
  pasture_id INT NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animal(id),
  FOREIGN KEY (pasture_id) REFERENCES pasture(id)
);

CREATE TABLE IF NOT EXISTS user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL,
  farm_id INT NOT NULL,
  FOREIGN KEY (farm_id) REFERENCES farm(id)
);

ALTER TABLE user CHANGE username user_name VARCHAR(255) NOT NULL UNIQUE;
ALTER TABLE user CHANGE role role ENUM('ADMIN', 'VET', "FARMER") NOT NULL;

CREATE TABLE IF NOT EXISTS permission (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  slug VARCHAR(255) NOT NULL,
  UNIQUE (slug)
);

INSERT INTO permission (name, slug) VALUES
    ('Administrador', "ADMIN"),
    ('Fazendeiro', "FARMER"),
    ('Veterin??rio', "VET");

CREATE TABLE IF NOT EXISTS user_permission (
    user_id INT NOT NULL,
    permission_id INT NOT NULL,
    PRIMARY KEY (user_id, permission_id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
);

INSERT INTO user_permission (user_id, permission_id) VALUES
    (1, 1);