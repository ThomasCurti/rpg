SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rpgdb` DEFAULT CHARACTER SET utf8 ;
USE `rpgdb` ;


-- -----------------------------------------------------
-- Table `rpgdb`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`class` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`guild`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`guild` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `level` INT(11) NOT NULL,
  `slogan` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`account` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `guild_id` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_account_guild`
    FOREIGN KEY (`guild_id`)
    REFERENCES `rpgdb`.`guild` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`characters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`characters` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pseudo` VARCHAR(20) NOT NULL,
  `class_id` INT(11),
  `account_id` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_characters_class`
    FOREIGN KEY (`class_id`)
    REFERENCES `rpgdb`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_character_account`
    FOREIGN KEY (`account_id`)
    REFERENCES `rpgdb`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(128) NOT NULL,
  `characters_id` INT(11),
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_items_characters`
    FOREIGN KEY (`characters_id`)
    REFERENCES `rpgdb`.`characters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`skills` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(128) NOT NULL,
  `class_id` INT(11),
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_skills_class`
    FOREIGN KEY (`class_id`)
    REFERENCES `rpgdb`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`pet` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `characters_id` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_pet_characters`
    FOREIGN KEY (`characters_id`)
    REFERENCES `rpgdb`.`characters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rpgdb`.`mount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rpgdb`.`mount` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `speed` INT(11) NOT NULL,
  `characters_id` INT(11),
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_mount_characters`
    FOREIGN KEY (`characters_id`)
    REFERENCES `rpgdb`.`characters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;