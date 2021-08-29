-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema BillPayment
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BillPayment
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BillPayment` ;
USE `BillPayment` ;

-- -----------------------------------------------------
-- Table `BillPayment`.`vendor_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`vendor_type` (
  `vt_id` INT NOT NULL AUTO_INCREMENT,
  `vt_type_name` VARCHAR(45) NULL,
  PRIMARY KEY (`vt_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`vendor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`vendor` (
  `ve_id` INT NOT NULL AUTO_INCREMENT,
  `ve_name` VARCHAR(50) NULL,
  `ve_reg_num` VARCHAR(45) NULL,
  `ve_type_id` INT NULL,
  `ve_address` VARCHAR(45) NULL,
  `ve_country` VARCHAR(45) NULL,
  `ve_state` VARCHAR(45) NULL,
  `ve_email` VARCHAR(45) NULL,
  `ve_contact` VARCHAR(45) NULL,
  `ve_site` VARCHAR(45) NULL,
  `ve_cer_issue_date` DATE NULL,
  `ve_cer_validity_date` DATE NULL,
  `ve_year` YEAR(4) NULL,
  `ve_payment` VARCHAR(45) NULL,
  `ve_user_name` VARCHAR(45) NOT NULL,
  `ve_password` VARCHAR(45) NULL,
  `ve_status` VARCHAR(45) NULL,
  PRIMARY KEY (`ve_id`),
  INDEX `ve_vt_fk_idx` (`ve_type_id` ASC) VISIBLE,
  UNIQUE INDEX `ve_user_name_UNIQUE` (`ve_user_name` ASC) VISIBLE,
  CONSTRAINT `ve_vt_fk`
    FOREIGN KEY (`ve_type_id`)
    REFERENCES `BillPayment`.`vendor_type` (`vt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`customer` (
  `cu_id` INT NOT NULL AUTO_INCREMENT,
  `cu_first_name` VARCHAR(45) NULL,
  `cu_last_name` VARCHAR(45) NULL,
  `cu_age` INT NULL,
  `cu_gender` VARCHAR(45) NULL,
  `cu_contact` VARCHAR(45) NULL,
  `cu_pan` VARCHAR(45) NULL,
  `cu_adhar` VARCHAR(45) NULL,
  `cu_user_id` VARCHAR(45) NULL,
  `cu_password` VARCHAR(45) NULL,
  PRIMARY KEY (`cu_id`),
  UNIQUE INDEX `cu_user_id_UNIQUE` (`cu_user_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`admin` (
  `ad_name` VARCHAR(45) NOT NULL,
  `ad_password` VARCHAR(45) NULL,
  PRIMARY KEY (`ad_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`payment_type` (
  `pt_id` INT NOT NULL,
  `pt_type` VARCHAR(45) NULL,
  PRIMARY KEY (`pt_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`card` (
  `ca_id` INT NOT NULL AUTO_INCREMENT,
  `ca_num` BIGINT(20) NULL,
  `ca_cvv` INT NULL,
  `ca_expiry_date` DATE NULL,
  PRIMARY KEY (`ca_id`),
  UNIQUE INDEX `ca_num_UNIQUE` (`ca_num` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`phone` (
  `ph_id` INT NOT NULL AUTO_INCREMENT,
  `ph_upi_id` INT NULL,
  PRIMARY KEY (`ph_id`),
  UNIQUE INDEX `ph_upi_id_UNIQUE` (`ph_upi_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`net_banking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`net_banking` (
  `nb_id` INT NOT NULL AUTO_INCREMENT,
  `nb_account_number` VARCHAR(45) NULL,
  `nb_user_id` VARCHAR(45) NULL,
  `nb_password` VARCHAR(45) NULL,
  PRIMARY KEY (`nb_id`),
  UNIQUE INDEX `nb_account_number_UNIQUE` (`nb_account_number` ASC) VISIBLE,
  UNIQUE INDEX `nb_user_id_UNIQUE` (`nb_user_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BillPayment`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BillPayment`.`bill` (
  `bi_id` INT NOT NULL AUTO_INCREMENT,
  `bi_amount` INT NULL,
  `bi_date` DATE NULL,
  `bi_ve_id` INT NULL,
  `bi_pt_id` INT NULL,
  `bi_ca_id` INT NULL,
  `bi_ph_id` INT NULL,
  `bi_nb_id` INT NULL,
  `bi_cu_user_id` VARCHAR(45) NULL,
  PRIMARY KEY (`bi_id`),
  INDEX `fk_ve_bi_idx` (`bi_ve_id` ASC) VISIBLE,
  INDEX `fk_bi_tr_idx` (`bi_pt_id` ASC) VISIBLE,
  INDEX `fk_bi_ca_idx` (`bi_ca_id` ASC) VISIBLE,
  INDEX `fk_bi_ph_idx` (`bi_ph_id` ASC) VISIBLE,
  INDEX `fk_bi_nb_idx` (`bi_nb_id` ASC) VISIBLE,
  INDEX `fk_cu_user_id_idx` (`bi_cu_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_bi_ve`
    FOREIGN KEY (`bi_ve_id`)
    REFERENCES `BillPayment`.`vendor` (`ve_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bi_tr`
    FOREIGN KEY (`bi_pt_id`)
    REFERENCES `BillPayment`.`payment_type` (`pt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bi_ca`
    FOREIGN KEY (`bi_ca_id`)
    REFERENCES `BillPayment`.`card` (`ca_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bi_ph`
    FOREIGN KEY (`bi_ph_id`)
    REFERENCES `BillPayment`.`phone` (`ph_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bi_nb`
    FOREIGN KEY (`bi_nb_id`)
    REFERENCES `BillPayment`.`net_banking` (`nb_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cu_user_id`
    FOREIGN KEY (`bi_cu_user_id`)
    REFERENCES `BillPayment`.`customer` (`cu_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
