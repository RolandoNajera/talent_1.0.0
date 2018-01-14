/**
January 2018 ERNV
Database for Talentsel application

*/

/* Tabla que contiene la información de login de un usuario, con correo o teléfono como uso de inicio de sesión*/
CREATE TABLE User (
idUser 				INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
mail 			VARCHAR(150) NOT NULL,
phone 			VARCHAR(15),
password		VARCHAR(50),
creationDate	TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
updateDate		TIMESTAMP,
status			INT(2) DEFAULT 1 NOT NULL
)ENGINE = INNODB;
CREATE UNIQUE INDEX idx_user_id ON User (idUser);

/* Tabla de perfiles */
CREATE TABLE Profile (
idProfile				INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
names			VARCHAR(150),
firstLastName	VARCHAR(100),
secondLastName	VARCHAR(100),
firstPhone		VARCHAR(15),
secondPhone		VARCHAR(15),
mail			VARCHAR(150),
rfc				VARCHAR(15),
picture			VARCHAR(150),
pictureThumb	VARCHAR(150),
linkLinkedin	VARCHAR(150),
linkFacebook	VARCHAR(150),
linkTwitter		VARCHAR(150),
linkWebsite		VARCHAR(150),
streetName		VARCHAR(110),
suburb			VARCHAR(60),
zipCode			INT(5),
town			VARCHAR(70),
city			VARCHAR(30),
creationDate	TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,	
updateDate		TIMESTAMP,	
status			INT(2) DEFAULT 1 NOT NULL
)ENGINE = INNODB;
CREATE UNIQUE INDEX idx_profile_id ON Profile (idProfile);

/* Tabla que guarda las experiencias que serán asociadas a los perfiles*/
CREATE TABLE Experience (
idExperience 	INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
company 		VARCHAR(110),
project 		VARCHAR(150),
creationDate 	TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
startDate 		TIMESTAMP NOT NULL,
idProfile 		INT(6) UNSIGNED,
endDate 		TIMESTAMP,
updateDate 		TIMESTAMP NULL,
status 			INT(2) DEFAULT 1 NOT NULL		
)ENGINE = INNODB;
CREATE UNIQUE INDEX idx_experience_id ON Experience (idExperience);
ALTER TABLE Experience ADD CONSTRAINT FK_experience_profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile) ON UPDATE CASCADE ON DELETE CASCADE;

/* Catálogo de Habilidades */
CREATE TABLE Ability (
idAbility 		INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name 			VARCHAR(80),
description 	VARCHAR(200),
type			VARCHAR(50),
experienceLevel	INT(1),
idProfile 		INT(6) UNSIGNED,
creationDate 	TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
updateDate 		TIMESTAMP NULL,
status 			INT(2) DEFAULT 1 NOT NULL
)ENGINE = INNODB;
CREATE UNIQUE INDEX idx_ability_id ON Ability (idAbility);
ALTER TABLE Ability ADD CONSTRAINT FK_ability_profile FOREIGN KEY (idProfile) REFERENCES Profile(idProfile) ON UPDATE CASCADE ON DELETE CASCADE;
