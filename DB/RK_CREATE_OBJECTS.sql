/* DROP FOREIGN KEY */
ALTER TABLE Ability DROP FOREIGN KEY FK_ability_profile;
ALTER TABLE Experience DROP FOREIGN KEY FK_experience_profile;

/* DROP INDEX */
ALTER TABLE Ability DROP INDEX idx_ability_id;
ALTER TABLE Experience DROP INDEX idx_experience_id;
ALTER TABLE Profile DROP INDEX idx_profile_id;
ALTER TABLE User DROP INDEX idx_user_id;

/* DROP TABLE */
DROP TABLE Ability;
DROP TABLE Experience;
DROP TABLE Profile;
DROP TABLE User;
