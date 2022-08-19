CREATE DATABASE acme_plan_service;
CREATE USER 'acme_db_user' IDENTIFIED BY 'acme_db_2022_casualty!pronoun()';
GRANT ALL PRIVILEGES ON acme_plan_service.* to acme_db_user;
USE acme_plan_service;
