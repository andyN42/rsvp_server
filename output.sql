-- MySQL Script generated by MySQL Workbench
-- 01/27/15 11:16:34
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rsvp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rsvp` DEFAULT CHARACTER SET utf8 ;
USE `rsvp` ;

-- -----------------------------------------------------
-- Table `rsvp`.`guest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rsvp`.`guest` ;

CREATE TABLE IF NOT EXISTS `rsvp`.`guest` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(90) NULL DEFAULT NULL,
  `lastName` VARCHAR(90) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(90) NULL DEFAULT NULL,
  `address` VARCHAR(90) NULL DEFAULT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `mealId` INT(11) NULL DEFAULT NULL,
  `plusOneId` INT(11) NULL DEFAULT NULL,
  `statusId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rsvp`.`meal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rsvp`.`meal` ;

CREATE TABLE IF NOT EXISTS `rsvp`.`meal` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(90) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rsvp`.`plusone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rsvp`.`plusone` ;

CREATE TABLE IF NOT EXISTS `rsvp`.`plusone` (
  `id` INT(11) NOT NULL,
  `guestID` INT(11) NOT NULL,
  `Name` VARCHAR(90) NULL DEFAULT NULL,
  `mealId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `guestkey_idx` (`guestID` ASC),
  CONSTRAINT `guestkey`
    FOREIGN KEY (`guestID`)
    REFERENCES `rsvp`.`guest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rsvp`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rsvp`.`status` ;

CREATE TABLE IF NOT EXISTS `rsvp`.`status` (
  `id` INT(11) NOT NULL,
  `value` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;